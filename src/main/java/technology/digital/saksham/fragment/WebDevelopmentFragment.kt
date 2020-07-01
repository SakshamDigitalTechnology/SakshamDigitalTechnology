package technology.digital.saksham.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import technology.digital.saksham.R
import technology.digital.saksham.adapter.WebDevelopmentAdapter

class WebDevelopmentFragment : Fragment() {

    var recyclerView: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.activity_web_development_fragment, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById<RecyclerView>(R.id.webdevelopment_recyclerview)
        recyclerView!!.setHasFixedSize(true)

        val layoutManager: RecyclerView.LayoutManager
        layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager

        var webDevelopmentadapter = WebDevelopmentAdapter(view.context)
        recyclerView!!.adapter = webDevelopmentadapter


    }


}