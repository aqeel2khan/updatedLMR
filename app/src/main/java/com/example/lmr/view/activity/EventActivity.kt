package com.example.lmr.view.activity

import androidx.activity.viewModels
import com.example.lmr.databinding.ActivityEventBinding
import com.example.lmr.view.BaseActivity
import com.example.lmr.viewmodel.BaseViewModel
import com.example.lmr.viewmodel.BasicDetailViewModel
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