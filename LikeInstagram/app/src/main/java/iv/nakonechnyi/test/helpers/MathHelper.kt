package iv.nakonechnyi.test.helpers

import iv.nakonechnyi.test.data.Post
import iv.nakonechnyi.test.data.Profile

class MathHelper {

    companion object{

        fun otherLinkedMembersCount(post: Post) =
            post.linked.size.let {
                if (it <= 3) {
                    ""
                } else {
                    " and <b><a href=\"${post.user.url}\">${it - 3} others</a></b>"
                }
            }
    }
}