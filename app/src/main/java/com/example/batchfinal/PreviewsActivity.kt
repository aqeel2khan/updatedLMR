package com.example.ajzoproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.ajzoproject.dashboard.DashboardActivity
import com.example.batchfinal.R
import com.example.batchfinal.databinding.ActivityOrganigerDetailsBinding
import com.example.batchfinal.databinding.ActivityPreviewsBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.AllViewModel
import com.example.batchfinal.viewmodel.BaseViewModel


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class PreviewsActivity : BaseActivity<ActivityPreviewsBinding>() {
    private val viewModel: AllViewModel by viewModels()

//    @SuppressLint("SetTextI18n")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_previews)
//        mBinding = ActivityPreviewsBinding.inflate(layoutInflater)
//        setContentView(mBinding.root)
//
//        mBinding.savePostBtn.setOnClickListener{
//            startActivity(Intent(this , DashboardActivity::class.java))
//        }
//
//        mBinding.buttonReadMore.setOnClickListener{
//            if (mBinding.textViewContent.maxLines === Int.MAX_VALUE) {
//                mBinding.textViewContent.maxLines = 3
//                mBinding.buttonReadMore.text = "Read More"
//            } else {
//                mBinding.textViewContent.maxLines = Int.MAX_VALUE
//                mBinding.buttonReadMore.text = "Read Less"
//            }
//        }
//
//        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
//        detailsTextView.text = "Previews"
//
//    }

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

