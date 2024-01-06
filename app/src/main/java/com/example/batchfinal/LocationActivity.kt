package com.example.ajzoproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.batchfinal.R
import com.example.batchfinal.databinding.ActivityEventDescriptionBinding
import com.example.batchfinal.databinding.ActivityLocationBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.BaseViewModel
import com.example.batchfinal.viewmodel.BasicDetailViewModel

class LocationActivity :  BaseActivity<ActivityLocationBinding>() {
    private val viewModel: BasicDetailViewModel by viewModels()

    //    @SuppressLint("MissingInflatedId", "SetTextI18n")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_location)
//        mBinding = ActivityLocationBinding.inflate(layoutInflater)
//        setContentView(mBinding.root)
//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
//        supportActionBar!!.setDisplayShowTitleEnabled(false)
//
//        //<-- Header Text View -->
//        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
//        detailsTextView.text = "Location Details"
//
//
//        mBinding.addLocationLater.setOnClickListener {
//            startActivity(Intent(this,OrganizerDetailsActivity::class.java))
//        }
//
//    }
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
            startActivity(Intent(this,OrganizerDetailsActivity::class.java))
        }
    }
    override fun getViewBinding()=ActivityLocationBinding.inflate(layoutInflater)
}