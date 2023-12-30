package com.example.batchfinal.view.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import com.example.batchfinal.R
import com.example.batchfinal.databinding.ActivityOnBoardingBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.AllViewModel
import com.example.batchfinal.viewmodel.BaseViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingActivity : BaseActivity<ActivityOnBoardingBinding>() {
    private val viewModel: AllViewModel by viewModels()
    override fun getViewModel(): BaseViewModel {
       return viewModel
    }

    override fun initUi() {
        binding.loginButton.setOnClickListener {
            startActivity(Intent(this@OnBoardingActivity, LoginActivity::class.java))
        }
    }

    override fun getViewBinding() = ActivityOnBoardingBinding.inflate(layoutInflater)

}