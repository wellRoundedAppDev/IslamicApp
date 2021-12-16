package com.example.islamicapp.ui.home.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicapp.R

class HadeethNamesAdapter(val items: MutableList<String>) :
    RecyclerView.Adapter<HadeethNamesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.hadeeth_name_item_label)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hadeeth_name, parent, false)

        return ViewHolder(view)
    }

    var onItemCLickListener: OnItemClickListener? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val hadeethName = items.get(position)
        holder.name.setText(hadeethName)

        if (onItemCLickListener != null) {

            holder.itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View?) {

                    onItemCLickListener?.onItemClick(position, hadeethName)
                }
            })
        }
    }

    override fun getItemCount(): Int = items.size


    interface OnItemClickListener {

        fun onItemClick(position: Int, item: String)
    }

}