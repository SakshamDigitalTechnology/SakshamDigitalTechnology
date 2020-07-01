package technology.digital.saksham.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import technology.digital.saksham.R
import technology.digital.saksham.adapter.HomeFragmentRecyclerAdapter

class HomeFragment : Fragment() {

    var recyclerView: RecyclerView? = null
    var linearLayout_all_technolohy: LinearLayout? = null
    var linearLayout_web_development: LinearLayout? = null
    var linearLayout_mobile_app: LinearLayout? = null
    var linearLayout_marketing: LinearLayout? = null
    var textView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.activity_home_fragment, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById<RecyclerView>(R.id.homefrag_recyclerview)
        textView = view.findViewById(R.id.logout_textview)

        recyclerView!!.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager
        layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager
        var homeFragmentRecyclerAdapter = HomeFragmentRecyclerAdapter(view.context)
        recyclerView!!.adapter = homeFragmentRecyclerAdapter


        // Work on Tab CLick

        linearLayout_all_technolohy = view.findViewById(R.id.alltechnology_linearlayout)

        linearLayout_all_technolohy!!.setOnClickListener({


            var fragmentManager = fragmentManager?.beginTransaction()
                ?.replace(R.id.root_layout, AllTechnologyFragment(), "AllTechnology")

            fragmentManager?.commit()

        })

        linearLayout_web_development = view.findViewById(R.id.webdevelopment_linearlayout)
        linearLayout_web_development!!.setOnClickListener({


            var fragmentManager = fragmentManager?.beginTransaction()
                ?.replace(R.id.root_layout, WebDevelopmentFragment(), "Web Development")

            fragmentManager?.commit()

        })

        linearLayout_mobile_app = view.findViewById(R.id.linearlayout_mobileapp)
        linearLayout_mobile_app!!.setOnClickListener({

            var fragmentManager =
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.root_layout, MobileAppFragment(), "MobileApp")
            fragmentManager?.commit()

        })

        linearLayout_marketing = view.findViewById(R.id.linearlayout_marketing)
        linearLayout_marketing!!.setOnClickListener({
            var fragmentManager =
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.root_layout, MarketingFragment(), "Marketing")
            fragmentManager?.commit()
        })


    }


}