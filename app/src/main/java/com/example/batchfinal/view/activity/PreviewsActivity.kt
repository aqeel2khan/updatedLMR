package com.example.batchfinal.view.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.widget.TextView
import androidx.activity.viewModels
import com.example.ajzoproject.dashboard.DashboardActivity
import com.example.batchfinal.R
import com.example.batchfinal.databinding.ActivityPreviewsBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.BaseViewModel
import com.example.batchfinal.viewmodel.PreviewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class PreviewsActivity : BaseActivity<ActivityPreviewsBinding>() {
    private val viewModel: PreviewsViewModel by viewModels()

    override fun getViewModel(): BaseViewModel {
        return  viewModel
    }

    @SuppressLint("SetTextI18n")
    override fun initUi() {
        binding.savePostBtn.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }

        binding.buttonReadMore.setOnClickListener {
            if (binding.textViewContent.maxLines === Int.MAX_VALUE) {
                binding.textViewContent.maxLines = 3
                binding.buttonReadMore.text = "Read More"
            } else {
                binding.textViewContent.maxLines = Int.MAX_VALUE
                binding.buttonReadMore.text = "Read Less"
            }
        }

        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        detailsTextView.text = "Previews"
    }

    override fun getViewBinding()= ActivityPreviewsBinding.inflate(layoutInflater)
}

