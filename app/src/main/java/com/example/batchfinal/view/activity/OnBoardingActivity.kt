package com.example.batchfinal.view.activity

import androidx.activity.viewModels
import com.example.batchfinal.databinding.ActivityOnBoardingBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.AllViewModel
import com.example.batchfinal.viewmodel.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingActivity : BaseActivity<ActivityOnBoardingBinding>() {
    private val viewModel: AllViewModel by viewModels()
    override fun getViewModel(): BaseViewModel {
       return viewModel
    }

    override fun initUi() {
        binding.loginButton.setOnClickListener {
        }
    }

    override fun getViewBinding() = ActivityOnBoardingBinding.inflate(layoutInflater)

}