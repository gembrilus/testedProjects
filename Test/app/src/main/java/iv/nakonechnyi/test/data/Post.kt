package iv.nakonechnyi.test.data

import java.lang.StringBuilder

data class Post(
    var user: Profile = Profile(),
    var photos: List<String> = emptyList(),
    var linked: List<Profile> = emptyList(),
    var message: Message = Message(),
    var time: String = ""
)