package technology.digital.saksham.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import technology.digital.saksham.R
import technology.digital.saksham.fragment.ViewAllFragment
import technology.digital.saksham.util.SharedPref

class WebDevelopmentAdapter(val context: Context) :
    RecyclerView.Adapter<WebDevelopmentAdapter.Viewholder>() {


    var image = arrayOf(
        R.drawable.ic_java,
        R.drawable.ic_python,
        R.drawable.ic_html_css_javascript,
        R.drawable.ic_php
    )


    var coursename = arrayOf(
        "Java with Webdevelopment",
        "Python With Djnago",
        "Html + Css + JavaScript",
        "Php With WebDevelopment"
    )


    var shortdesc = arrayOf(
        R.string.CoreJava, R.string.PythonWithDjnago, R.string.HtmlCssJavaScript,
        R.string.PhpWithWebDevelopment

    )

    var prize = arrayOf(
        "Rs.7000/-",
        "Rs.9000/-",
        "Rs.3000/-",
        "Rs.4500/-"

    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return WebDevelopmentAdapter.Viewholder(
            LayoutInflater.from(context)
                .inflate(R.layout.activity_web_development_adapter, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return image.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {

        holder.imageView.setImageResource(image[position])
        holder.textView_course_name.text = coursename[position]
        holder.textView_course_shortdec.setText(shortdesc[position])
        holder.textView_course_prize.text = prize[position]


        holder.textView_viemore.setOnClickListener({


            if (position == 0) {
                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "Java with Webdevelopment")
                SharedPref.getInstance(context).writecoursename("Java with Webdevelopment")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)

                        .commit()
            } else if (position == 1) {

                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "Python With Djnago")
                SharedPref.getInstance(context).writecoursename("Python With Djnago")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)

                        .commit()

            } else if (position == 2) {

                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "Html + Css + JavaScript")
                SharedPref.getInstance(context).writecoursename("Html + Css + JavaScript")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)

                        .commit()

            } else if (position == 3) {

                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "Php With WebDevelopment")
                SharedPref.getInstance(context).writecoursename("Php With WebDevelopment")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)

                        .commit()

            }


        })

    }

    class Viewholder(view: View) : RecyclerView.ViewHolder(view) {

        var imageView = view.findViewById<ImageView>(R.id.imageview_course_webdevelopment)
        var textView_course_name = view.findViewById<TextView>(R.id.course_name_webdevelopment)
        var textView_course_shortdec =
            view.findViewById<TextView>(R.id.course_short_topic_webdevelopment)
        var textView_course_prize = view.findViewById<TextView>(R.id.course_prize_webdevelopment)
        var textView_viemore = view.findViewById<TextView>(R.id.viewmore_webdevelopment)
    }


}