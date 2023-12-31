package com.example.ajzoproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ajzoproject.dashboard.DashboardActivity
import com.example.ajzoproject.databinding.ActivityPreviewsBinding


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class PreviewsActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityPreviewsBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_previews)
        mBinding = ActivityPreviewsBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.savePostBtn.setOnClickListener{
            startActivity(Intent(this , DashboardActivity::class.java))
        }

        mBinding.buttonReadMore.setOnClickListener{
            if (mBinding.textViewContent.maxLines === Int.MAX_VALUE) {
                mBinding.textViewContent.maxLines = 3
                mBinding.buttonReadMore.text = "Read More"
            } else {
                mBinding.textViewContent.maxLines = Int.MAX_VALUE
                mBinding.buttonReadMore.text = "Read Less"
            }
        }

        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        detailsTextView.text = "Previews"

    }
}

