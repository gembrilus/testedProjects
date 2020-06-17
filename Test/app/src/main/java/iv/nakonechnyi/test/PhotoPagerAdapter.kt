package iv.nakonechnyi.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import iv.nakonechnyi.test.helpers.FileHelper
import kotlinx.android.synthetic.main.view_pager_item.view.*

class PhotoPagerAdapter(private val list: List<String>) : RecyclerView.Adapter<PhotoPagerAdapter.PhotoHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoPagerAdapter.PhotoHolder =
        LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item, parent, false).run(::PhotoHolder)

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {

        with(holder.itemView) {
            iv_photo_gallery.setImageDrawable(
                FileHelper.getImageFromAssetByName(context, list[position])
            )
        }
    }

    inner class PhotoHolder(view: View): RecyclerView.ViewHolder(view)
}