package technology.digital.saksham.customview

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class CustomTabLayout : TabLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!,
        attrs,
        defStyleAttr
    )

    override fun setupWithViewPager(viewPager: ViewPager?) {
        super.setupWithViewPager(viewPager)
        val typeface =
            Typeface.createFromAsset(context.assets, "fonts/Montserrat-Regular.ttf")
        if (typeface != null) {
            removeAllTabs()
            val slidingTabStrip = getChildAt(0) as ViewGroup
            val adapter = viewPager!!.adapter
            var i = 0
            val count = adapter!!.count
            while (i < count) {
                val tab = newTab()
                this.addTab(tab.setText(adapter.getPageTitle(i)))
                val view =
                    (slidingTabStrip.getChildAt(i) as ViewGroup).getChildAt(1) as AppCompatTextView
                view.setTypeface(typeface, Typeface.NORMAL)
                i++
            }
        }
    }
}