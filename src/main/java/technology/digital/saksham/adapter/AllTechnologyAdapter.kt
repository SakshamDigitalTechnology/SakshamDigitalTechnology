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

class AllTechnologyAdapter(val context: Context) :
    RecyclerView.Adapter<AllTechnologyAdapter.ViewHolder>() {

    var image = arrayOf(
        R.drawable.ic_android,
        R.drawable.ic_android,
        R.drawable.ic_learning,
        R.drawable.ic_java,
        R.drawable.ic_python,
        R.drawable.ic_html_css_javascript,
        R.drawable.ic_digitalmarketing,
        R.drawable.ic_php,
        R.drawable.ic_core_python,
        R.drawable.ic_candplus,
        R.drawable.ic_seosmm,
        R.drawable.ic_iot,
        R.drawable.ic_iphone


    )

    var coursename = arrayOf(
        "Android With Kotlin",
        "Android With Java",
        "Python With Machine Learning",
        "Core Java",
        "Python With Djnago",
        "Html + Css + JavaScript",
        "Digital Marketing",
        "Php With WebDevelopment",
        "Core Python",
        "C and C++",
        "SEO +SMM",
        "Internet of Things",
        "Iphone App Development"
    )


    var shortdesc = arrayOf(
        R.string.androidwithKotlin,
        R.string.androidwithjava,
        R.string.PythonWthMachineLearning,
        R.string.CoreJava,
        R.string.PythonWithDjnago,
        R.string.HtmlCssJavaScript,
        R.string.digitalmarketing,
        R.string.PhpWithWebDevelopment,
        R.string.CorePython,
        R.string.Candplus,
        R.string.SEOSMM,
        R.string.InternetofThings,
        R.string.IphoneAppDevelopment

    )

    var prize = arrayOf(
        "Rs.7000/-",
        "Rs.9000/-",
        "Rs.3000/-",
        "Rs.4500/-",
        "Rs.6500/-",
        "Rs.7500/-",
        "Rs.6500/-",
        "Rs.5500/-",
        "Rs.9000/-",
        "Rs.3000/-",
        "Rs.4500/-",
        "Rs.6500/-",
        "Rs.9000/-"
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.activity_all_technology_adapter, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return image.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.imageView.setImageResource(image[position])
        holder.textView_course_name.text = coursename[position]
        holder.textView_course_shortdec.setText(shortdesc[position])
        holder.textView_course_prize.text = prize[position]
        holder.textView_viemore.setOnClickListener({

            if (position == 0) {
                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "Android With Kotlin")
                SharedPref.getInstance(context).writecoursename("Android With Kotlin")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)
                        .commit()
            } else if (position == 1) {

                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "Android With Java")
                SharedPref.getInstance(context).writecoursename("Android With Java")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)
                        .commit()

            } else if (position == 2) {

                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "Python With Machine Learning")
                SharedPref.getInstance(context).writecoursename("Python With Machine Learning")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)
                        .commit()

            } else if (position == 3) {

                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "Core Java")
                SharedPref.getInstance(context).writecoursename("Core Java")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)
                        .commit()

            } else if (position == 4) {

                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "Python With Djnago")
                SharedPref.getInstance(context).writecoursename("Python With Djnago")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)

                        .commit()

            } else if (position == 5) {

                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "Html + Css + JavaScript")
                SharedPref.getInstance(context).writecoursename("Html + Css + JavaScript")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)

                        .commit()

            } else if (position == 6) {

                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "Digital Marketing")
                SharedPref.getInstance(context).writecoursename("Digital Marketing")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)

                        .commit()

            } else if (position == 7) {

                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "Php With WebDevelopment")
                SharedPref.getInstance(context).writecoursename("Php With WebDevelopment")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)

                        .commit()

            } else if (position == 8) {

                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "Core Python")
                SharedPref.getInstance(context).writecoursename("Core Python")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)

                        .commit()

            } else if (position == 9) {

                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "C and C++")
                SharedPref.getInstance(context).writecoursename("C and C++")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)

                        .commit()

            } else if (position == 10) {

                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "SEO +SMM")
                SharedPref.getInstance(context).writecoursename("SEO +SMM")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)

                        .commit()

            } else if (position == 11) {

                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "Internet of Things")
                SharedPref.getInstance(context).writecoursename("Internet of Things")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)

                        .commit()

            } else if (position == 12) {

                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "Iphone App Development")
                SharedPref.getInstance(context).writecoursename("Iphone App Development")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)

                        .commit()

            }


        })

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView = view.findViewById<ImageView>(R.id.imageview_course_alltechnology)
        var textView_course_name = view.findViewById<TextView>(R.id.course_name_alltechnology)
        var textView_course_shortdec =
            view.findViewById<TextView>(R.id.course_short_topic_alltechnology)
        var textView_course_prize = view.findViewById<TextView>(R.id.course_prize_alltechnology)
        var textView_viemore = view.findViewById<TextView>(R.id.viewmore_alltechnology)


    }


}

