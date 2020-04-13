package com.example.recyclerviewexam3

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_model.view.*

class DataAdapter(val list:List<Int>,val layout:Int) : RecyclerView.Adapter<DataViewHolder>() {
    val selectionList = mutableListOf<Long>()
    var onItemSelectedListener : ((MutableList<Long>)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout,parent,false)

        view.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val id = v?.tag
                if(selectionList.contains(id)) selectionList.remove(id)
                else selectionList.add(id as Long)
                notifyDataSetChanged()
                onItemSelectedListener?.let{it(selectionList)}
            }
        })
        return DataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.containerView.textView.text = list[position].toString()
        holder.containerView.tag = getItemId(position)
        holder.containerView.isActivated = selectionList.contains(getItemId(position))

    }
}