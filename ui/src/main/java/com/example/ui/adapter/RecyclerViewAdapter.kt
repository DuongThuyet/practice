package com.example.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ui.R
import com.example.ui.model.ItemPopularViewHolderModel
import com.example.ui.util.autoGenBackground


class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    private var data = ItemPopularViewHolderModel(listOf(), mutableListOf())

    fun setData(data: ItemPopularViewHolderModel) {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        if (!data.isInitBg[position]) {
            holder.txtUserName.autoGenBackground()
            data.isInitBg.add(position, true)
        }
        holder.txtUserName.text = data.listItem[position]
    }

    override fun getItemCount(): Int {
        return data.listItem.size
    }


    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtUserName: TextView = itemView.findViewById(R.id.tvKeyPopular)

    }
}