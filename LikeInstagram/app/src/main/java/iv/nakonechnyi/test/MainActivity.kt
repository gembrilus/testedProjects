package iv.nakonechnyi.test

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import iv.nakonechnyi.test.helpers.FileHelper
import iv.nakonechnyi.test.helpers.showToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bitmap_image_to_bottom_navigation.view.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private val navigationItemListener by lazy {
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_item_home -> showToast("Go to home page").run { true }
                R.id.menu_item_search -> showToast("Go to Search page").run { true }
                R.id.menu_item_add_photo -> showToast("Add new photo").run { true }
                R.id.menu_item_love_it -> showToast("Add to favorites").run { true }
                R.id.menu_item_profile_image -> showToast("Open your profile").run { true }
                else -> false
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host)

        with(nav_view) {
            setupWithNavController(navController)
            setOnNavigationItemSelectedListener(navigationItemListener)
        }

        btn_logo.setOnClickListener {
            if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {
                startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE), 1)
            } else {
                showToast(getString(R.string.text_when_on_logo_clicked))
            }
        }

        btn_send_to.setOnClickListener {
            showToast(getString(R.string.text_when_on_send_to_clicked))
        }


        val params: FrameLayout.LayoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            gravity = Gravity.END
            marginStart = 16
            marginEnd = 16
        }

        val image = LayoutInflater.from(this)
            .inflate(R.layout.bitmap_image_to_bottom_navigation, nav_view, false)

        nav_view.addView(image, params)

        Glide.with(this)
            .load(FileHelper.getImageFromAssetByName(this, "me.jpg"))
            .apply(RequestOptions.circleCropTransform())
            .into(image.iv_my_profile)

    }

    fun onItemClick(view: View) {
        val message = when (view.id) {
            R.id.iv_user_logo -> "Go to user's profile"
            R.id.btn_more -> "More options for this post"
            R.id.btn_love -> "I like this post!"
            R.id.btn_comment -> "Open coments for this post or add new comment"
            R.id.btn_send_to -> "Share this post with your friends"
            R.id.btn_to_bookmark -> "Add the post to your bookmarks"
            else -> "This button is not clickable"
        }
        showToast(message)
    }

}