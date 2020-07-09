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


class HomeFragmentRecyclerAdapter(val context: Context) : RecyclerView.Adapter<ViewHolder>() {


    var image = arrayOf(
        R.drawable.ic_android,
        R.drawable.ic_learning,
        R.drawable.ic_java,
        R.drawable.ic_python,
        R.drawable.ic_digitalmarketing

    )

    var coursename = arrayOf(
        "Android With Kotlin",
        "Python With Machine Learning",
        "Core Java",
        "Python",
        "Digital Marketing"
    )

    var shortdesc = arrayOf(

        R.string.androidwithKotlin, R.string.PythonWthMachineLearning,
        R.string.CoreJava, R.string.CorePython, R.string.digitalmarketing

    )

    var cost = arrayOf(
        "Rs.700/-", "Rs.900/-", "Rs.5000/-", "Rs.5000/-", "Rs.8000/-"
    )


    override fun getItemCount(): Int {
        return image.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.activity_home_fragment_recycler_adapter, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.courseimage.setImageResource(image[position])
        holder.coursename1.text = coursename[position]
        holder.courseshortDesc.setText(shortdesc[position])
        holder.courseprice.text = cost[position]


        holder.viewmore.setOnClickListener({
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
                args.putString("coursename", "Python With Machine Learning")
                SharedPref.getInstance(context).writecoursename("Python With Machine Learning")

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
                args.putString("coursename", "Python")
                SharedPref.getInstance(context).writecoursename("Python")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)
                        .commit()

            } else if (position == 4) {

                val viewAllFragment = ViewAllFragment()
                val args = Bundle()
                args.putString("coursename", "Digital Marketing")
                SharedPref.getInstance(context).writecoursename("Digital Marketing")

                viewAllFragment.arguments = args
                val manager =
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.root_layout, viewAllFragment).addToBackStack(null)

                        .commit()

            }


        })


    }


}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    var courseimage = view.findViewById<ImageView>(R.id.imageview_course)
    var coursename1 = view.findViewById<TextView>(R.id.course_name)
    var courseshortDesc = view.findViewById<TextView>(R.id.course_short_topic)
    var courseprice = view.findViewById<TextView>(R.id.course_prize)
    var viewmore = view.findViewById<TextView>(R.id.viewall_homefragment)


}