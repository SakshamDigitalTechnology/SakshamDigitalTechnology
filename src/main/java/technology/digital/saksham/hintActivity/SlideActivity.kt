package technology.digital.saksham.hintActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import technology.digital.saksham.R
import technology.digital.saksham.activity.CourseActivity
import technology.digital.saksham.activity.HomeActivity
import technology.digital.saksham.adapter.SlideViewPagerAdapter
import technology.digital.saksham.util.SharedPref


class SlideActivity : AppCompatActivity() {
    var sharedPref: SharedPref? = null

    companion object {
        var viewPager: ViewPager? = null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)
        sharedPref = SharedPref.getInstance(this@SlideActivity)
        viewPager = findViewById<ViewPager>(R.id.viewpager)
        var adapter = SlideViewPagerAdapter(this)
        viewPager!!.adapter = adapter


        if (isOpenAlread()) {
            if (SharedPref.getInstance(this).isLogin == true) {
                val intent = Intent(this, CourseActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this@SlideActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }


        } else {
            val editor =
                getSharedPreferences("slide", Context.MODE_PRIVATE).edit()
            editor.putBoolean("slide", true)
            editor.commit()
        }


    }

    private fun isOpenAlread(): Boolean {

        val sharedPreferences =
            getSharedPreferences("slide", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("slide", false)

    }


}