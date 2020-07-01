package technology.digital.saksham.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import technology.digital.saksham.R
import technology.digital.saksham.customview.CustomTabLayout
import technology.digital.saksham.fragment.LoginFragment
import technology.digital.saksham.fragment.SignUpFragment


class HomeActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    var mTabLayout: CustomTabLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mTabLayout = findViewById(R.id.tabs)
        viewPager = findViewById(R.id.home_viewpager)

        setupViewPager(viewPager)
        mTabLayout!!.setupWithViewPager(viewPager)


    }

    private fun setupViewPager(viewPager: ViewPager?) {
        val adapter = LoginSignupAdapter(supportFragmentManager)
        adapter.addFragment(LoginFragment(), "SIGN IN")
        adapter.addFragment(SignUpFragment(), "SIGN UP")
        viewPager!!.adapter = adapter


    }


}


internal class LoginSignupAdapter(manager: FragmentManager) :
    FragmentPagerAdapter(manager) {
    private val mFragmentList: MutableList<Fragment> = ArrayList()
    private val mFragmentTitleList: MutableList<String> = ArrayList()
    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }
}