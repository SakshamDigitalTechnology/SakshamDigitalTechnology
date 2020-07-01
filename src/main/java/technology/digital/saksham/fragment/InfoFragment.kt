package technology.digital.saksham.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import technology.digital.saksham.R
import technology.digital.saksham.util.SharedPref

class InfoFragment : Fragment() {

    var imageView: ImageView? = null
    var textView_short_descr: TextView? = null
    var textView_expected_time: TextView? = null
    var textView_need_language: TextView? = null
    var button_buy: Button? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.activity_info_fragment, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = view.findViewById(R.id.imageview_infotab)
        textView_short_descr = view.findViewById(R.id.aboutcourse_infotab)
        textView_expected_time = view.findViewById(R.id.expectedtime_infotab)
        textView_need_language = view.findViewById(R.id.eneedlanguage_infotab)
        button_buy = view.findViewById(R.id.info_buy_button)

        var coursename = SharedPref.getInstance(context).getcoursename()
        if (coursename.equals("Android With Kotlin")) {
            imageView!!.setImageResource(R.drawable.kotlin)
            textView_short_descr!!.setText(R.string.kotlin)
            textView_expected_time!!.text = "3 Month"
            textView_need_language!!.text = "Oops Concepts,Android,Kotlin"

        } else if (coursename.equals("Python With Machine Learning")) {
            imageView!!.setImageResource(R.drawable.ic_facebook)
            textView_short_descr!!.setText(R.string.machinelearning)
            textView_expected_time!!.text = "1 Month"
            textView_need_language!!.text = "Basic Python,Modules,Numpy,Matplotlib"
        } else if (coursename.equals("Python With Machine Learning")) {
            imageView!!.setImageResource(R.drawable.ic_facebook)
            textView_short_descr!!.setText(R.string.machinelearning)
            textView_expected_time!!.text = "1 Month"
            textView_need_language!!.text = "Basic Python,Modules,Numpy,Matplotlib"
        } else if (coursename.equals("Android With Java")) {
            imageView!!.setImageResource(R.drawable.ic_android)
            textView_short_descr!!.setText(R.string.androidwithjava)
            textView_expected_time!!.text = "3 Month"
            textView_need_language!!.text = "Opps in Java,Android"
        } else if (coursename.equals("Core Java")) {
            imageView!!.setImageResource(R.drawable.ic_java)
            textView_short_descr!!.setText(R.string.corejava)
            textView_expected_time!!.text = "1 Month"
            textView_need_language!!.text = "C and C++"
        } else if (coursename.equals("Core Python")) {
            imageView!!.setImageResource(R.drawable.ic_core_python)
            textView_short_descr!!.setText(R.string.python)
            textView_expected_time!!.text = "1 Month"
            textView_need_language!!.text = "Knowledge about Computer Programming"
        } else if (coursename.equals("Python")) {
            imageView!!.setImageResource(R.drawable.ic_core_python)
            textView_short_descr!!.setText(R.string.python)
            textView_expected_time!!.text = "1 Month"
            textView_need_language!!.text = "Knowledge about Computer Programming"
        } else if (coursename.equals("Python With Djnago")) {
            imageView!!.setImageResource(R.drawable.ic_core_python)
            textView_short_descr!!.setText(R.string.python)
            textView_expected_time!!.text = "1 Month"
            textView_need_language!!.text = "Basic Python,HTML,CSS ,Django"
        } else if (coursename.equals("Digital Marketing")) {
            imageView!!.setImageResource(R.drawable.ic_digitalmarketing)
            textView_short_descr!!.setText(R.string.digitalmarketing_shortdetails)
            textView_expected_time!!.text = "45 days"
            textView_need_language!!.text =
                "Knowledge about Computer,How to use Internet,HOw to use Social Networking Sites"
        } else if (coursename.equals("Html + Css + JavaScript")) {
            imageView!!.setImageResource(R.drawable.ic_html_css_javascript)
            textView_short_descr!!.setText(R.string.HtmlCssJavaScript)
            textView_expected_time!!.text = "45 days"
            textView_need_language!!.text = "Knowledge about Computer"
        } else if (coursename.equals("Php With WebDevelopment")) {
            imageView!!.setImageResource(R.drawable.ic_php)
            textView_short_descr!!.setText(R.string.PhpWithWebDevelopment)
            textView_expected_time!!.text = "45 days"
            textView_need_language!!.text = "Knowledge about Computer"
        } else if (coursename.equals("Java with Webdevelopment")) {
            imageView!!.setImageResource(R.drawable.ic_java)
            textView_short_descr!!.setText(R.string.corejava)
            textView_expected_time!!.text = "3 month"
            textView_need_language!!.text = "Core Java,Advance Java"
        } else if (coursename.equals("C and C++")) {
            imageView!!.setImageResource(R.drawable.ic_candplus)
            textView_short_descr!!.setText(R.string.c)
            textView_expected_time!!.text = "45 days"
            textView_need_language!!.text = "Knowledge about Computer"
        } else if (coursename.equals("SEO +SMM")) {
            imageView!!.setImageResource(R.drawable.ic_digitalmarketing)
            textView_short_descr!!.setText(R.string.digitalmarketing_shortdetails)
            textView_expected_time!!.text = "45 days"
            textView_need_language!!.text = "Knowledge about Computer"
        } else if (coursename.equals("Internet of Things")) {
            imageView!!.setImageResource(R.drawable.ic_iot)
            textView_short_descr!!.setText(R.string.iot)
            textView_expected_time!!.text = "45 days"
            textView_need_language!!.text = "C,iot,Hardware"
        } else if (coursename.equals("Internet of Things")) {
            imageView!!.setImageResource(R.drawable.ic_iot)
            textView_short_descr!!.setText(R.string.iot)
            textView_expected_time!!.text = "45 days"
            textView_need_language!!.text = "C,iot,Hardware"
        } else if (coursename.equals("Iphone App Development")) {
            imageView!!.setImageResource(R.drawable.ic_apple)
            textView_short_descr!!.setText(R.string.ios)
            textView_expected_time!!.text = "3 Moths"
            textView_need_language!!.text = "Swift,Objective C"
        }


    }
}













