package com.example.batchfinal.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batchfinal.adapter.BatchWorkoutTypeAdapter
import com.example.batchfinal.adapter.WorkoutTypeAdapter
import com.example.batchfinal.databinding.ActivityWeightLossBatchBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.AllViewModel
import com.example.batchfinal.viewmodel.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeightLossBatchActivity : BaseActivity<ActivityWeightLossBatchBinding>() {
   private val viewModel: AllViewModel by viewModels()
   override fun getViewModel(): BaseViewModel {
      return viewModel
   }

   override fun initUi() {
      setWorkoutTypeAdapter()
   }

   private fun setWorkoutTypeAdapter() {
      binding.recyclerWorkoutType.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
      binding.recyclerWorkoutType.adapter = BatchWorkoutTypeAdapter(this@WeightLossBatchActivity)
   }

   override fun getViewBinding() = ActivityWeightLossBatchBinding.inflate(layoutInflater)
}