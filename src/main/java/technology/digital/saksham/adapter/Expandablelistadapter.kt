package technology.digital.saksham.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import technology.digital.saksham.R


class Expandablelistadapter(
    private val context: Context,
    private val groups: Array<String>,
    private val children: Array<Array<String>>
) :
    BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return groups.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return children[groupPosition].size
    }

    override fun getGroup(groupPosition: Int): Any {
        return groups[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return children[groupPosition][childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }


    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val view =
            convertView ?: LayoutInflater.from(context).inflate(R.layout.expandable_group, null)
        val textView = view.findViewById<TextView>(R.id.heading_title)
        textView.text = groups[groupPosition]
        return view

    }


    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {

        val view =
            convertView ?: LayoutInflater.from(context).inflate(R.layout.expandable_child, null)
        val textView = view.findViewById<TextView>(R.id.title_child)
        textView.text = children[groupPosition][childPosition]
        return view

    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }


}