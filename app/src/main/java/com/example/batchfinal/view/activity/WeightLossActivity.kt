package com.example.batchfinal.view.activity

import android.content.Intent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batchfinal.R
import com.example.batchfinal.adapter.RecommendedProductListAdapter
import com.example.batchfinal.adapter.WorkoutTypeAdapter
import com.example.batchfinal.databinding.ActivityWeightLossBinding
import com.example.batchfinal.`interface`.PositionItemClickListener
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.AllViewModel
import com.example.batchfinal.viewmodel.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeightLossActivity : BaseActivity<ActivityWeightLossBinding>() {
    private val viewModel: AllViewModel by viewModels()

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun initUi() {
        buttonClicks()
        val aniSlide: Animation = AnimationUtils.loadAnimation(applicationContext, R.anim.bottom_top)
        binding.relWeightLayout.startAnimation(aniSlide)
        setWorkoutTypeAdapter()
    }

    private fun setWorkoutTypeAdapter() {
        binding.recyclerWorkoutType.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerWorkoutType.adapter = WorkoutTypeAdapter(this@WeightLossActivity)
    }

    private fun buttonClicks() {
        binding.imgBack.setOnClickListener {
            onBackPressed()
            finish()
        }
        binding.btnSubscribe.setOnClickListener {
            startActivity(Intent(this@WeightLossActivity, BuySubscriptionActivity::class.java))
        }
    }

    override fun getViewBinding() = ActivityWeightLossBinding.inflate(layoutInflater)
}