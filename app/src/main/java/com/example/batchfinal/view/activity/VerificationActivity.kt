package com.example.batchfinal.view.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import com.example.batchfinal.R
import com.example.batchfinal.databinding.ActivityVerificationBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.AllViewModel
import com.example.batchfinal.viewmodel.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VerificationActivity : BaseActivity<ActivityVerificationBinding>() {
    private val viewModel: AllViewModel by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun initUi() {
        binding.verificationButton.setOnClickListener {
            startActivity(Intent(this, ExploreActivity::class.java))
        }

    }

    override fun getViewBinding() = ActivityVerificationBinding.inflate(layoutInflater)
}