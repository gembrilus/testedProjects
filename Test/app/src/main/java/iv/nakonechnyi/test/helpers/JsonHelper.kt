package iv.nakonechnyi.test.helpers

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import iv.nakonechnyi.test.data.Post
import java.lang.reflect.Type




class JsonHelper {

    companion object{

        fun fromJson(json: String) : List<Post>? {

            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            val type: Type = Types.newParameterizedType(
                MutableList::class.java,
                Post::class.java
            )

            val adapter : JsonAdapter<List<Post>> = moshi.adapter(type)

            return adapter.fromJson(json)
        }

    }

}