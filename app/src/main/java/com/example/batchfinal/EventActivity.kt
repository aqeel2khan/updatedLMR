package com.example.ajzoproject

import androidx.activity.viewModels
import com.example.batchfinal.databinding.ActivityEventBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.BaseViewModel
import com.example.batchfinal.viewmodel.BasicDetailViewModel

class EventActivity : BaseActivity<ActivityEventBinding>() {
    private val viewModel: BasicDetailViewModel by viewModels()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_event)
//    }
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }
    override fun initUi() {
    }
    override fun getViewBinding() = ActivityEventBinding.inflate(layoutInflater)
}