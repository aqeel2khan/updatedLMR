package com.example.lmr.view.activity

import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lmr.databinding.ActivityWeightLossBatchBinding
import com.example.lmr.adapter.BatchWorkoutTypeAdapter
import com.example.lmr.view.BaseActivity
import com.example.lmr.viewmodel.AllViewModel
import com.example.lmr.viewmodel.BaseViewModel
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