package technology.digital.saksham.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.fragment.app.Fragment
import technology.digital.saksham.R
import technology.digital.saksham.adapter.Expandablelistadapter
import technology.digital.saksham.util.SharedPref


class SyllbusFragment : Fragment() {

    var coursename: String? = null

    private var groups_kotlin: Array<String> = arrayOf(
        "Introduction to Kotlin",
        "Installation of kotlin",
        "Variable in Kotlin",
        "Data Types in Kotlin"
    )
    private var children_kotlin: Array<Array<String>> = arrayOf(
        arrayOf(
            "What is Kotlin\n" +
                    "Why We Use Kotlin\n" +
                    "Java Vs Kotlin\n" +
                    "Demand of Kotlin in Mobile App\n" +
                    "How to use Kotlin in Android App Development\n" +
                    "Kotlin Histroty\n" +
                    "Kotlin Versions"
        ),
        arrayOf(
            "1.Install JDK\n" +
                    "\n" +
                    "2.Install IntelliJ IDEA\n" +
                    "\n" +
                    "3.Setup the environment"
        ),

        arrayOf(
            "Variable Concept\n" +
                    "Define Variable\n" +
                    "What is Variable\n" +
                    "What is val and var\n" +
                    "null safety"
        ),

        arrayOf(
            "Primitive data types and their limitations\n" +
                    "Integer Datatypes\n" +
                    "Floating-Point DataType"
        )
    )


    private var groups_machinelearning: Array<String> = arrayOf(
        "Introduction to Machine Learning",
        "Installation of Machine",
        "Variable in Machine",
        "Data Types in machine"
    )
    private var children_machinelearning: Array<Array<String>> = arrayOf(
        arrayOf(
            "What is Kotlin\n" +
                    "Why We Use Kotlin\n" +
                    "Java Vs Kotlin\n" +
                    "Demand of Kotlin in Mobile App\n" +
                    "How to use Kotlin in Android App Development\n" +
                    "Kotlin Histroty\n" +
                    "Kotlin Versions"
        ),
        arrayOf(
            "1.Install JDK\n" +
                    "\n" +
                    "2.Install IntelliJ IDEA\n" +
                    "\n" +
                    "3.Setup the environment"
        ),

        arrayOf(
            "Variable Concept\n" +
                    "Define Variable\n" +
                    "What is Variable\n" +
                    "What is val and var\n" +
                    "null safety"
        ),

        arrayOf(
            "Primitive data types and their limitations\n" +
                    "Integer Datatypes\n" +
                    "Floating-Point DataType"
        )
    )


    private var groups_corejava: Array<String> = arrayOf(
        "Feature of Java",
        "Installation of Java",
        "Data Types",
        "Operator in Java"
    )
    private var children_corejava: Array<Array<String>> = arrayOf(
        arrayOf(
            "What is Java\n" +
                    "Why Java\n" +
                    "Overview Of Java\n" +
                    "Difference b/w C and C  \n" +
                    "Why Java Most Popular "
        ),
        arrayOf(
            "Install JDK\n" +
                    "Intsall JRE\n" +
                    "Set path of JRE\n" +
                    "Structure of JDK\n" +
                    "Structure of JRE\n" +
                    "Working of JDK\n" +
                    "Working of JRE\n" +
                    "What is JVM\n" +
                    "What is JIT\n" +
                    "What is Compiler"
        ),

        arrayOf(
            "Primitive Data Type\n" +
                    "\n" +
                    "Non-Primitive Data Type\n" +
                    "\n" +
                    "Numeric Literals\n" +
                    "\n" +
                    "Character Literals\n" +
                    "\n" +
                    "String \n" +
                    "\n" +
                    "Int\n" +
                    "\n" +
                    "Float\n" +
                    "\n" +
                    "Double\n" +
                    "\n" +
                    "char\n" +
                    "\n" +
                    "long\n" +
                    "\n" +
                    "Arrays\n" +
                    "\n" +
                    "One dimensional Arrays\n" +
                    "\n" +
                    " two-dimensional Arrays\n" +
                    "\n" +
                    "Array of Object References\n" +
                    "\n" +
                    "Accessing arrays, manipulating arrays\n" +
                    "\n" +
                    "Enumerated Data Types\n" +
                    "\n" +
                    "Non-Primitive Datatypes\n" +
                    "\n" +
                    "Defining a class, variable and method in Java"
        ),

        arrayOf(
            "Assignment Operator\n" +
                    "Arithmetic Operators\n" +
                    "Relational Operators\n" +
                    "Logical Operators\n" +
                    "Conditional Operators\n" +
                    "Operator Precedence\n" +
                    "Implicit Type Conversions\n" +
                    "Upcasting and downcasting\n" +
                    "Strict typing\n" +
                    "Type conversion"
        )
    )


    private var groups_python: Array<String> = arrayOf(
        "Introduction to Python",
        "Python DataTypes And Variable",
        "Looping",
        "Control Statement"
    )
    private var children_python: Array<Array<String>> = arrayOf(
        arrayOf(
            "Overview of Python\n" +
                    "The Companies using Python\n" +
                    "Different Applications where Python is used\n" +
                    "Install Python Software"
        ),
        arrayOf(
            "Number Datatypes\n" +
                    "String Data Types\n" +
                    "List\n" +
                    "Tuple\n" +
                    "Dictionary \n" +
                    "Set"
        ),

        arrayOf(
            "For\n" +
                    "While Loop\n" +
                    "Nested loop\n" +
                    "Foreach loop"
        ),

        arrayOf(
            "if/else\n" +
                    "Nested if-else\n" +
                    "switch\n" +
                    "for loop in python\n" +
                    "foreach loop in python\n" +
                    "How to make pattern in python using loop\n" +
                    "Break\n" +
                    "Continue\n" +
                    "Pass"
        )
    )


    private var groups_digitalmarketing: Array<String> = arrayOf(
        "Introduction to Digital Marketing",
        "Search Engine optimization",
        "On Page SEO",
        "Off Page SEO"
    )
    private var children_digitalmarketing: Array<Array<String>> = arrayOf(
        arrayOf(
            "Digital marketing overview\n" +
                    "Traditional Vs. Digital Marketing\n" +
                    "Digital Marketing Channels\n" +
                    "Digital Marketing metrics\n" +
                    "Audience research\n" +
                    "Industry Trend Research\n" +
                    "Competitive research platforms and tools "
        ),
        arrayOf(
            "What is SEO\n" +
                    "Why we use SEO for website rank\n" +
                    "How search engine work for website search\n" +
                    "Search engine algorithm\n" +
                    "google algorithm updates"
        ),

        arrayOf(
            "Title tag optimization\n" +
                    "URL optimization\n" +
                    "Meta description\n" +
                    "Unique Meta Tags for each page\n" +
                    "H1 optimization\n" +
                    "H2 optimization\n" +
                    "How to use other header tags\n" +
                    "Alt tags optimization\n" +
                    "Meta keywords\n" +
                    "Content optimization\n" +
                    "Page quality"
        ),

        arrayOf(
            "What is Off-Page SEO\n" +
                    "Off-Page and its Techniques\n" +
                    "Social media presence\n" +
                    "Google & Bing Business Listings\n" +
                    "Create backlinks\n" +
                    "Why backlinks are important\n" +
                    "Types of backlinks\n" +
                    "DoFollow backlinks\n" +
                    "NoFollow backlinks"
        )
    )


    private var groups_nothing: Array<String> = arrayOf(
        "There is not Updated Content Please wait for Updatation"

    )
    private var children_nothing: Array<Array<String>> = arrayOf(
        arrayOf("")

    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        coursename = SharedPref.getInstance(context).getcoursename()



        return inflater.inflate(R.layout.activity_syllbus_fragment, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var expandableListView =
            view.findViewById<ExpandableListView>(R.id.expandablelistview_syllbus)

        if (coursename.equals("Android With Kotlin")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_kotlin,
                    children_kotlin
                )
            )
        } else if (coursename.equals("Python With Machine Learning")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_machinelearning,
                    children_machinelearning
                )
            )
        } else if (coursename.equals("Python Wth MachineLearning")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_machinelearning,
                    children_machinelearning
                )
            )
        } else if (coursename.equals("Html + Css + JavaScript")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_nothing,
                    children_nothing
                )
            )
        } else if (coursename.equals("Core Java")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_corejava,
                    children_corejava
                )
            )
        } else if (coursename.equals(" Android With Java")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_corejava,
                    children_corejava
                )
            )
        } else if (coursename.equals("Python")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_python,
                    children_python
                )
            )
        } else if (coursename.equals("Core Python")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_python,
                    children_python
                )
            )
        } else if (coursename.equals("Python With Djnago")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_python,
                    children_python
                )
            )
        } else if (coursename.equals("Php With WebDevelopment")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_nothing,
                    children_nothing
                )
            )
        } else if (coursename.equals("Digital Marketing")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_digitalmarketing,
                    children_digitalmarketing
                )
            )
        } else if (coursename.equals("C and C++")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_nothing,
                    children_nothing
                )
            )
        } else if (coursename.equals("SEO +SMM")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_nothing,
                    children_nothing
                )
            )
        } else if (coursename.equals("Internet of Things")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_nothing,
                    children_nothing
                )
            )
        } else if (coursename.equals("Iphone App Development")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_nothing,
                    children_nothing
                )
            )
        } else if (coursename.equals("Html + Css + JavaScript")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_nothing,
                    children_nothing
                )
            )
        } else if (coursename.equals("Php With WebDevelopment")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_nothing,
                    children_nothing
                )
            )
        } else if (coursename.equals("C and C++")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_nothing,
                    children_nothing
                )
            )
        } else if (coursename.equals("SEO +SMM")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_nothing,
                    children_nothing
                )
            )
        } else if (coursename.equals("Internet of Things")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_nothing,
                    children_nothing
                )
            )
        } else if (coursename.equals("Iphone App Development")) {
            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_nothing,
                    children_nothing
                )
            )
        } else {

            expandableListView.setAdapter(
                Expandablelistadapter(
                    view.context,
                    groups_nothing,
                    children_nothing
                )
            )

        }


    }


}