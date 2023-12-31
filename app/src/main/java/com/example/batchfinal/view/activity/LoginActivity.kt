package com.example.batchfinal.view.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import com.example.batchfinal.R
import com.example.batchfinal.custom.CustomToast.Companion.showToast
import com.example.batchfinal.databinding.ActivityLoginBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.AllViewModel
import com.example.batchfinal.viewmodel.BaseViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    private val viewModel: AllViewModel by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun initUi() {
       buttonClicks()
    }

    @SuppressLint("ResourceAsColor")
    private fun buttonClicks() {
        binding.personalTextView.setOnClickListener {
            binding.personalTextView.setBackgroundResource(R.drawable.circle_shap_allo)
            binding.personalTextView.setTextColor(R.color.blue)
            binding.businessTextView.setBackgroundResource(R.drawable.circle_shap)
            binding.businessTextView.setTextColor(R.color.grey)
        }

        binding.businessTextView.setOnClickListener {
            binding.businessTextView.setBackgroundResource(R.drawable.circle_shap_allo)
            binding.businessTextView.setTextColor(R.color.blue)
            binding.personalTextView.setBackgroundResource(R.drawable.circle_shap)
            binding.personalTextView.setTextColor(R.color.grey)
        }

        binding.loginButton.setOnClickListener {
            val intentObj = Intent(this, VerificationActivity::class.java)
            val numberType = binding.numberEditText.text.toString()
            val countryCode = binding.countryCodeText.text.toString()
            intentObj.putExtra("number", numberType)
            intentObj.putExtra("CountryCode", countryCode)
            startActivity(intentObj)
        }
    }

    override fun getViewBinding() = ActivityLoginBinding.inflate(layoutInflater)

    private fun setDividerWidth(divider: View) {
        val windowManager = windowManager
        val display = windowManager.defaultDisplay
        val screenWidth = display.width
        divider.layoutParams.width = screenWidth / 4.1.toInt()
        divider.requestLayout()
    }
}