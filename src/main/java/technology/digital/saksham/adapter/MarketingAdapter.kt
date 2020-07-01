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

class MarketingAdapter(val context: Context) : RecyclerView.Adapter<MarketingAdapter.ViewHolder>() {

    var image = arrayOf(

        R.drawable.ic_digitalmarketing,
        R.drawable.ic_seosmm


    )

    var coursename = arrayOf(
        "Digital Marketing",
        "SEO +SMM"
    )


    var shortdesc = arrayOf(
        R.string.digitalmarketing,
        R.string.SEOSMM

    )

    var prize = arrayOf(

        "Rs.6500/-",
        "Rs.3000/-"

    )


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imageView = view.findViewById<ImageView>(R.id.imageview_course_marketing)
        var textView_course_name = view.findViewById<TextView>(R.id.course_name_marketing)
        var textView_course_shortdec =
            view.findViewById<TextView>(R.id.course_short_topic_marketing)
        var textView_course_prize = view.findViewById<TextView>(R.id.course_prize_marketing)
        var textView_viemore = view.findViewById<TextView>(R.id.viewmore_marketing)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return MarketingAdapter.ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.activity_marketing_adapter, parent, false)
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
                args.putString("coursename", "Digital Marketing")
                SharedPref.getInstance(context).writecoursename("Digital Marketing")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)

                        .commit()

            } else if (position == 1) {

                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "SEO +SMM")
                SharedPref.getInstance(context).writecoursename("SEO +SMM")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)

                        .commit()

            }


        })


    }

}