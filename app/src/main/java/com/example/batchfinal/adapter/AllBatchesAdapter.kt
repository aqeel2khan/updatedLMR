package com.example.batchfinal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.batchfinal.databinding.ItemAllBatchesBinding
import com.example.batchfinal.`interface`.PositionItemClickListener
import java.util.ArrayList

class AllBatchesAdapter(val context: Context?, var name: ArrayList<String>, var listener: PositionItemClickListener<Int>) : RecyclerView.Adapter<AllBatchesAdapter.ViewHolder>(){
    inner class ViewHolder(val binding: ItemAllBatchesBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(name: String, position: Int) {
            binding.tvWorkoutName.text = name

            binding.root.setOnClickListener {
                listener.onPositionItemSelected(name, position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAllBatchesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return name.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(name[position], position)
    }
}