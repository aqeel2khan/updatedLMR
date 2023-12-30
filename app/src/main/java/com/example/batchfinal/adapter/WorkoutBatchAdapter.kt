package com.example.batchfinal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.batchfinal.databinding.ItemWorkoutBatchBinding
import com.example.batchfinal.`interface`.PositionItemClickListener
import java.util.ArrayList


class WorkoutBatchAdapter(val context: Context?, var name: ArrayList<String>, val lister: PositionItemClickListener<Int>) : RecyclerView.Adapter<WorkoutBatchAdapter.ViewHolder>(){
    inner class ViewHolder(val binding: ItemWorkoutBatchBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(name: String, position: Int) {
            binding.workoutType.text = name
            binding.root.setOnClickListener {
                lister.onPositionItemSelected(name, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWorkoutBatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return name.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(name[position], position)
    }
}