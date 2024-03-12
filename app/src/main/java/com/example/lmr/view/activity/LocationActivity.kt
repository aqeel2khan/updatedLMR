package com.example.lmr.view.activity

import android.content.Intent
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import com.example.lmr.R
import com.example.lmr.databinding.ActivityLocationBinding
import com.example.lmr.view.BaseActivity
import com.example.lmr.viewmodel.BaseViewModel
import com.example.lmr.viewmodel.LocationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationActivity :  BaseActivity<ActivityLocationBinding>() {
    private val viewModel: LocationViewModel by viewModels()
    override fun getViewModel(): BaseViewModel {
        return  viewModel
    }

    override fun initUi() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        //<-- Header Text View -->
        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        detailsTextView.text = "Location Details"
        binding.addLocationLater.setOnClickListener {
            startActivity(Intent(this, OrganizerDetailsActivity::class.java))
        }
    }
    override fun getViewBinding()=ActivityLocationBinding.inflate(layoutInflater)
}