package com.example.lmr.view.activity

import androidx.activity.viewModels
import com.example.lmr.databinding.ActivityExploreBinding
import com.example.lmr.view.BaseActivity
import com.example.lmr.viewmodel.AllViewModel
import com.example.lmr.viewmodel.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExploreActivity : BaseActivity<ActivityExploreBinding>() {
    private val viewModel: AllViewModel by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun initUi() {
        binding.backButtonBack.setOnClickListener {  }
        binding.continueButton.setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.signTextView.setOnClickListener {
//            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    override fun getViewBinding() = ActivityExploreBinding.inflate(layoutInflater)

}