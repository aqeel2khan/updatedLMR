package com.example.lmr.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lmr.R
import com.example.lmr.databinding.ItemListMotivatorBinding
//import com.example.lmr.R
//import com.example.lmr.databinding.ItemListMotivatorBinding
import com.example.lmr.`interface`.PositionItemClickListener
import java.util.ArrayList

class MotivatorListAdapter(
    val requireContext: Context,
    var courseImg: ArrayList<Int>,
    var techerName: ArrayList<String>,
    var profesion: ArrayList<String>,
    var listener: PositionItemClickListener<Int>) : RecyclerView.Adapter<MotivatorListAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemListMotivatorBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String, position: Int) {
            binding.txtTrainerName.text = name
            binding.txtProfesion.text = profesion[position]
            Glide.with(requireContext).load(courseImg[position])
                .placeholder(
                    R.drawable.profile_girl
                ).into(binding.imgTrainerProfile)

            binding.root.setOnClickListener {
                listener.onPositionItemSelected(name, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MotivatorListAdapter.ViewHolder {
        val binding = ItemListMotivatorBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MotivatorListAdapter.ViewHolder, position: Int) {
        holder.bind(techerName[position], position)
    }

    override fun getItemCount(): Int {
        return techerName.size
    }
}