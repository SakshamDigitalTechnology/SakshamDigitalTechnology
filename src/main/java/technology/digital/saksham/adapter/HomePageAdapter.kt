package technology.digital.saksham.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import technology.digital.saksham.fragment.CourseFragment
import technology.digital.saksham.fragment.HomeFragment
import technology.digital.saksham.fragment.MoreFragment
import technology.digital.saksham.fragment.ProfileFragment

class HomePageAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 ->
                return HomeFragment()
            1 ->
                return CourseFragment()
            2 ->
                return ProfileFragment()
            3 -> return MoreFragment()
        }
        return HomeFragment()
    }

    override fun getCount(): Int {
        return 4
    }

}

