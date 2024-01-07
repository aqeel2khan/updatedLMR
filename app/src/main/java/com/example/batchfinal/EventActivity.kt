package com.example.ajzoproject

import androidx.activity.viewModels
import com.example.batchfinal.databinding.ActivityEventBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.BaseViewModel
import com.example.batchfinal.viewmodel.BasicDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class EventActivity : BaseActivity<ActivityEventBinding>() {
    private val viewModel: BasicDetailViewModel by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }
    override fun initUi() {
    }
    override fun getViewBinding() = ActivityEventBinding.inflate(layoutInflater)
}