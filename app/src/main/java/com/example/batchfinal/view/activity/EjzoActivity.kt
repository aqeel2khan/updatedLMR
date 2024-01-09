package com.example.batchfinal.view.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.activity.viewModels
import com.example.batchfinal.R
import com.example.batchfinal.databinding.ActivityEjzoBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.BaseViewModel
import com.example.batchfinal.viewmodel.EjzoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EjzoActivity : BaseActivity<ActivityEjzoBinding>() {
    private val viewModel: EjzoViewModel by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun getViewBinding() = ActivityEjzoBinding.inflate(layoutInflater)

    @SuppressLint("ResourceAsColor")
    override fun initUi() {
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
            val intentObj = Intent(this, BasicDetailsActivity::class.java)
            val numberType = binding.numberEditText.text.toString()
            val countryCode = binding.countryCodeText.text.toString()
            intentObj.putExtra("number", numberType)
            intentObj.putExtra("CountryCode", countryCode)
            startActivity(intentObj)
        }
    }
}