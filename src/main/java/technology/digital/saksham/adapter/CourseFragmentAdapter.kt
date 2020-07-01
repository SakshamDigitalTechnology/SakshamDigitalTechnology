package technology.digital.saksham.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import technology.digital.saksham.R

class CourseFragmentAdapter(val context: Context) :
    RecyclerView.Adapter<CourseFragmentAdapter.ViewHolder>() {

    var image = arrayOf(
        R.drawable.ic_learning,
        R.drawable.ic_java,
        R.drawable.ic_python,
        R.drawable.ic_html_css_javascript,
        R.drawable.ic_digitalmarketing,
        R.drawable.ic_php,
        R.drawable.ic_core_python


    )


    var traningname = arrayOf(
        "Summer Training",
        "Classroom Training",
        "Online Training",
        "College Campus Trainig",
        "Industrial Training",
        "Minor/Major Project Training",
        "Workshop and Seminar"


    )

    var shortdectraning = arrayOf(
        R.string.summertraining,
        R.string.classroomtrainig,
        R.string.onlinetraining,
        R.string.collegecampustraining,
        R.string.industrialtraining,
        R.string.minormajorprojecttraining,
        R.string.workshopandseminor


    )


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseFragmentAdapter.ViewHolder {
        return CourseFragmentAdapter.ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.activity_course_fragment_adapter, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return traningname.size
    }

    override fun onBindViewHolder(holder: CourseFragmentAdapter.ViewHolder, position: Int) {

        holder.imageView.setImageResource(image[position])
        holder.textView_course_name.text = traningname[position]
        holder.textView_course_shortdec.setText(shortdectraning[position])
        holder.textView_viemore.setOnClickListener({


        })


    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        var imageView = view.findViewById<ImageView>(R.id.imageview_course_coursefragment)
        var textView_course_name = view.findViewById<TextView>(R.id.course_name_coursefragment)
        var textView_course_shortdec =
            view.findViewById<TextView>(R.id.course_short_topic_coursefragment)
        var textView_viemore = view.findViewById<TextView>(R.id.viewmore_coursefragment)


    }

}