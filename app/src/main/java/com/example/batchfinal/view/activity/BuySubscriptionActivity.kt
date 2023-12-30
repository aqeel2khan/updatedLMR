package com.example.batchfinal.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.batchfinal.databinding.ActivityBuySubscriptionBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.AllViewModel
import com.example.batchfinal.viewmodel.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BuySubscriptionActivity : BaseActivity<ActivityBuySubscriptionBinding>() {
  private val viewModel: AllViewModel by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun initUi() {
        buttonClicks()
    }

    private fun buttonClicks() {

    }

    override fun getViewBinding() = ActivityBuySubscriptionBinding.inflate(layoutInflater)
}