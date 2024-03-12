package com.example.lmr.view.activity

import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lmr.databinding.ActivityWeightLossBinding
import com.example.lmr.R
import com.example.lmr.view.BaseActivity
import com.example.lmr.viewmodel.AllViewModel
import com.example.lmr.viewmodel.BaseViewModel
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
        }
    }

    override fun getViewBinding() = ActivityWeightLossBinding.inflate(layoutInflater)
}