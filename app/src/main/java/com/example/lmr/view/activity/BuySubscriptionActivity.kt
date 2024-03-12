package com.example.lmr.view.activity

import androidx.activity.viewModels
import com.example.lmr.databinding.ActivityBuySubscriptionBinding
import com.example.lmr.view.BaseActivity
import com.example.lmr.viewmodel.AllViewModel
import com.example.lmr.viewmodel.BaseViewModel
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