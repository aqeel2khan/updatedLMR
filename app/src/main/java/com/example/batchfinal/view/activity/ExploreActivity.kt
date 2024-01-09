package com.example.batchfinal.view.activity

import androidx.activity.viewModels
import com.example.batchfinal.databinding.ActivityExploreBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.AllViewModel
import com.example.batchfinal.viewmodel.BaseViewModel
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