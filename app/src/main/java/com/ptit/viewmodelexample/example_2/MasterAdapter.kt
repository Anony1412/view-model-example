package com.ptit.viewmodelexample.example_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ptit.viewmodelexample.R

class MasterAdapter(
    private val onItemSelectedListener: (String) -> Unit
) : RecyclerView.Adapter<MasterViewHolder>() {

    var data = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MasterViewHolder {
        return MasterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false),
            onItemSelectedListener
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MasterViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun addData(data: List<String>) {
        if (this.data.isNotEmpty()) this.data.clear()
        this.data.addAll(data)
    }
}
