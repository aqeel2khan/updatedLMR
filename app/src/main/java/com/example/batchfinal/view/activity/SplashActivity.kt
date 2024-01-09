package com.example.batchfinal.view.activity

import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.example.batchfinal.databinding.ActivitySplashBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.AllViewModel
import com.example.batchfinal.viewmodel.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    private val viewModel: AllViewModel by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun initUi() {
        binding.apply {
            Handler(Looper.myLooper()!!).postDelayed({
                startActivity(Intent(this@SplashActivity, OnBoardingActivity::class.java).addFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
                finish()

            }, 2000)
        }
    }

    override fun getViewBinding() = ActivitySplashBinding.inflate(layoutInflater)
}