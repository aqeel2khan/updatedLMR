package com.example.lmr.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.lmr.model.response.AgeGroupData

class AgeGroupSpinnerAdapter (context: Context, private val items: MutableList<AgeGroupData>?) :
    ArrayAdapter<AgeGroupData>(context, android.R.layout.simple_spinner_dropdown_item, items!!) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createView(position, convertView, parent)
    }

    private fun createView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_spinner_dropdown_item, parent, false)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        val mEventCategory= items!![position]
        textView.text = mEventCategory?.age
//
        return view
    }
}