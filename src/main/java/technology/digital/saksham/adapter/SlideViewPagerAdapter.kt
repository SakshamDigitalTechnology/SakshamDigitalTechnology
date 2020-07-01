package technology.digital.saksham.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import technology.digital.saksham.R
import technology.digital.saksham.activity.HomeActivity
import technology.digital.saksham.hintActivity.SlideActivity
import technology.digital.saksham.util.SharedPref
import java.util.*


class SlideViewPagerAdapter(var ctx: Context) : PagerAdapter() {

    var currentPage = 0
    var timer: Timer? = null
    val DELAY_MS: Long = 500
    val PERIOD_MS: Long = 3000

    override fun getCount(): Int {
        return 3
    }

    override fun isViewFromObject(
        view: View,
        `object`: Any
    ): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater =
            ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View =
            layoutInflater.inflate(R.layout.activity_slide_view_pager_adapter, container, false)
        val logo = view.findViewById<ImageView>(R.id.logo)
        val ind1 = view.findViewById<ImageView>(R.id.ind1)
        val ind2 = view.findViewById<ImageView>(R.id.ind2)
        val ind3 = view.findViewById<ImageView>(R.id.ind3)
        val title = view.findViewById<TextView>(R.id.title)
        val desc = view.findViewById<TextView>(R.id.desc)
        val next = view.findViewById<ImageView>(R.id.next)
        val back = view.findViewById<ImageView>(R.id.back)
        val btnGetStarted =
            view.findViewById<Button>(R.id.btnGetStarted)
        btnGetStarted.setOnClickListener {
            val intent = Intent(ctx, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            ctx.startActivity(intent)

            SharedPref.getInstance(ctx).setLoginStatehint(true)

        }
        next.setOnClickListener { SlideActivity.viewPager!!.currentItem = position + 1 }
        back.setOnClickListener { SlideActivity.viewPager!!.currentItem = position - 1 }






        when (position) {
            0 -> {
                logo.setImageResource(R.drawable.logo1)
                ind1.setImageResource(R.drawable.seleted)
                ind2.setImageResource(R.drawable.unselected)
                ind3.setImageResource(R.drawable.unselected)
                title.text = "Shoping Place"
                desc.text = "This is random text taking from lorem ipsum tesing puspose"
                back.visibility = View.GONE
                next.visibility = View.VISIBLE
            }
            1 -> {
                logo.setImageResource(R.drawable.logo2)
                ind1.setImageResource(R.drawable.unselected)
                ind2.setImageResource(R.drawable.seleted)
                ind3.setImageResource(R.drawable.unselected)
                title.text = "Shopping on the way"
                desc.text = "This is random text taking from lorem ipsum tesing puspose"
                back.visibility = View.VISIBLE
                next.visibility = View.VISIBLE
            }
            2 -> {
                logo.setImageResource(R.drawable.logo3)
                ind1.setImageResource(R.drawable.unselected)
                ind2.setImageResource(R.drawable.unselected)
                ind3.setImageResource(R.drawable.seleted)
                title.text = "Pay on Delivery"
                desc.text = "This is random text taking from lorem ipsum tesing puspose"
                back.visibility = View.VISIBLE
                next.visibility = View.GONE
            }
        }
        container.addView(view)
        return view
    }

    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        `object`: Any
    ) {
        container.removeView(`object` as View)
    }

}