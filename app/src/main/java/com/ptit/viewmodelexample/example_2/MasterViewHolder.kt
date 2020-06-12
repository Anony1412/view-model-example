package com.ptit.viewmodelexample.example_2

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class MasterViewHolder(
    view: View,
    private val onItemSelectedListener: (String) -> Unit
) : RecyclerView.ViewHolder(view) {

    private var item: String? = null

    init {
        itemView.setOnClickListener { item?.let { onItemSelectedListener(it) } }
    }

    fun bind(item: String) {
        this.item = item
        itemView.textItemName.text = item
    }
}
