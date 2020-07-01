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

class MobileAppAdapter(val context: Context) : RecyclerView.Adapter<MobileAppAdapter.ViewHolder>() {

    var image = arrayOf(
        R.drawable.ic_android,
        R.drawable.ic_android,
        R.drawable.ic_java,
        R.drawable.ic_iphone


    )

    var coursename = arrayOf(
        "Android With Kotlin",
        "Android With Java",
        "Core Java",
        "Iphone App Development"
    )


    var shortdesc = arrayOf(
        R.string.androidwithKotlin, R.string.androidwithjava, R.string.PythonWthMachineLearning,
        R.string.IphoneAppDevelopment

    )

    var prize = arrayOf(
        "Rs.7000/-",
        "Rs.9000/-",
        "Rs.3000/-",
        "Rs.9000/-"
    )

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView = view.findViewById<ImageView>(R.id.imageview_course_mobileapp)
        var textView_course_name = view.findViewById<TextView>(R.id.course_name_mobileapp)
        var textView_course_shortdec =
            view.findViewById<TextView>(R.id.course_short_topic_mobileapp)
        var textView_course_prize = view.findViewById<TextView>(R.id.course_prize_mobileapp)
        var textView_viemore = view.findViewById<TextView>(R.id.viewmore_mobileapp)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return MobileAppAdapter.ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.activity_mobile_app_adapter, parent, false)
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
                args.putString("coursename", "Core Java")
                SharedPref.getInstance(context).writecoursename("Core Java")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)
                        .commit()

            } else if (position == 3) {

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

}