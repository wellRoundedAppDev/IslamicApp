package com.example.islamicapp.ui.suraDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicapp.R

class VersesAdapter : RecyclerView.Adapter<VersesAdapter.ViewHolder>() {

    var items: List<String>? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val verseTextView: TextView = itemView.findViewById(R.id.verse)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_verse, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val verse = items?.get(position)
        holder.verseTextView.setText(verse)
    }

    override fun getItemCount(): Int {

        return items?.size ?: 0
    }

    fun changeData(verses: List<String>) {

        this.items = verses
        notifyDataSetChanged()
    }
}