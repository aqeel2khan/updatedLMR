package com.example.batchfinal.view.activity
import android.annotation.SuppressLint
import android.content.Intent
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import com.example.batchfinal.R
import com.example.batchfinal.databinding.ActivityEventDescriptionBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.BaseViewModel
import com.example.batchfinal.viewmodel.EventDescriptionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventDescriptionActivity : BaseActivity<ActivityEventDescriptionBinding>() {
    private val viewModel: EventDescriptionViewModel by viewModels()

    override fun getViewModel(): BaseViewModel {
        return  viewModel
    }

    @SuppressLint("SetTextI18n")
    override fun initUi() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayShowTitleEnabled(false)
        binding.saveAndContinueButton.setOnClickListener {
            startActivity(Intent(this, DateTime3Activity::class.java))
        }
        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        detailsTextView.text = "More Details"
    }

    override fun getViewBinding() = ActivityEventDescriptionBinding.inflate(layoutInflater)
}