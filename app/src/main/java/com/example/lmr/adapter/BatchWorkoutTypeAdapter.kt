package com.example.lmr.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.batchfinal.databinding.ItemWorkoutTypeBinding

import com.example.lmr.databinding.ItemWorkoutTypeBinding


class BatchWorkoutTypeAdapter(val context: Context?) : RecyclerView.Adapter<BatchWorkoutTypeAdapter.ViewHolder>(){
    inner class ViewHolder(val binding: ItemWorkoutTypeBinding) : RecyclerView.ViewHolder(binding.root){
       /* fun bind(name: String, position: Int) {
            binding.workoutType.text = name
            binding.root.setOnClickListener {
                lister.onPositionItemSelected(name, position)
            }
        }*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWorkoutTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 6
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(name[position], position)
    }
}