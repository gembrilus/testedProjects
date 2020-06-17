package iv.nakonechnyi.test

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.tabs.TabLayoutMediator
import iv.nakonechnyi.test.data.Post
import iv.nakonechnyi.test.helpers.FileHelper
import iv.nakonechnyi.test.helpers.MathHelper
import kotlinx.android.synthetic.main.recycler_item.view.*


class ContentAdapter : RecyclerView.Adapter<ContentAdapter.Holder>() {

    private lateinit var view: View

    var posts: List<Post> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)
            .run(::Holder)

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val post = posts[position]
        view = holder.itemView

        with(view) {

            Glide.with(context)
                .load(
                    FileHelper.getImageFromAssetByName(
                        context,
                        "${position + 1}/${post.user.logo}"
                    )
                )
                .apply(RequestOptions.circleCropTransform())
                .into(iv_user_logo)

            content_photo.adapter = PhotoPagerAdapter(post.photos)

            TabLayoutMediator(pageIndicatorView, content_photo) { _, _ ->
            }.attach()

            tw_user_nick.text = post.user.name
            tw_link_to_user_page.text = "${post.user.place}>"
            tw_linked.text = Html.fromHtml(
                post.linked.joinToString(
                    separator = ", ",
                    prefix = "Linked by ",
                    postfix = "${MathHelper.otherLinkedMembersCount(post)}"
                ) {
                    "<b><a href=\"${it.url}\"><b>${it.name}</a></b>"
                }
            )
            tw_message.text = Html.fromHtml("<b>${post.user.name}</b> ${post.message.text}")
            tw_time.text = post.time
        }

    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view)

}