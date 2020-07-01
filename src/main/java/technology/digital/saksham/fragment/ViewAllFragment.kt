package technology.digital.saksham.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import technology.digital.saksham.R
import technology.digital.saksham.activity.CourseActivity

class ViewAllFragment : Fragment() {
    var tabLayout: TabLayout? = null
    var recyclerView: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.activity_view_all_fragment, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var imageView = view.findViewById<ImageView>(R.id.imageview_viewall_back)
        var textView = view.findViewById<TextView>(R.id.viewall_coursename_textview)
        tabLayout = view.findViewById(R.id.tabs_viewall)

        imageView.setOnClickListener({

            val myIntent = Intent(activity, CourseActivity::class.java)
            activity!!.startActivity(myIntent)
            activity!!.finish()

        })


        val value = arguments!!.getString("coursename")
        textView.text = value

        actiononTab(tabLayout)


    }

    private fun actiononTab(tabLayout: TabLayout?) {

        (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.viewall_framelayout, InfoFragment()).addToBackStack(null)
            .commit()

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

                when (tab!!.position) {

                    0 ->
                        (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                            .replace(R.id.viewall_framelayout, InfoFragment()).addToBackStack(null)
                            .commit()
                    1 ->
                        (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                            .replace(R.id.viewall_framelayout, SyllbusFragment())
                            .addToBackStack(null)
                            .commit()


                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

                when (tab!!.position) {

                    0 ->
                        (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                            .replace(R.id.viewall_framelayout, InfoFragment()).addToBackStack(null)
                            .commit()
                    1 ->
                        (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                            .replace(R.id.viewall_framelayout, SyllbusFragment())
                            .addToBackStack(null)
                            .commit()


                }


            }
        })

    }


}