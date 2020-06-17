package iv.nakonechnyi.test.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import iv.nakonechnyi.test.ContentAdapter
import iv.nakonechnyi.test.R
import iv.nakonechnyi.test.helpers.FileHelper
import iv.nakonechnyi.test.helpers.JsonHelper
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {

    private val adapter by lazy {
        ContentAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(content_home) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@HomeFragment.adapter
        }

        GlobalScope.launch(Dispatchers.IO) {
            FileHelper.readJsonFromFile(requireContext(), "content.json").also { json ->
                JsonHelper.fromJson(json)?.also { list ->
                    withContext(Dispatchers.Main) {
                        adapter.posts = list
                    }
                }
            }
        }
    }
}