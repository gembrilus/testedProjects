package iv.nakonechnyi.test.helpers

import android.content.Context
import android.graphics.drawable.Drawable

class FileHelper {

    companion object {

        fun readJsonFromFile(context: Context, name: String): String =
            context.assets.open(name)
                .bufferedReader()
                .use { it.readText() }

        fun getImageFromAssetByName(context: Context, name: String): Drawable =
            context.assets.open(name).use {
                Drawable.createFromStream(it, null)
            }
    }

}