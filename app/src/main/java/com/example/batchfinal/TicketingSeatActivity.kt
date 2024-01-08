package com.example.ajzoproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatButton
import com.example.batchfinal.R
import com.example.batchfinal.databinding.ActivityPreviewsBinding

import com.example.batchfinal.databinding.ActivityTicketingSeatBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.AllViewModel
import com.example.batchfinal.viewmodel.BaseViewModel
import com.example.batchfinal.viewmodel.TicketingSeatViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class TicketingSeatActivity : BaseActivity<ActivityTicketingSeatBinding>() {
    private val viewModel: TicketingSeatViewModel by viewModels()

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }
    @SuppressLint("SetTextI18n")
    override fun initUi() {
        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        detailsTextView.text = "Ticketing/ Seat Details"
        val spinner = findViewById<Spinner>(R.id.VisibilitySpinner)
        val array = arrayListOf("Visible", "Not Visible")
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
        binding.addbttn.setOnClickListener {
            startActivity(Intent(this, PreviewsActivity::class.java))
        }
    }
    override fun getViewBinding() = ActivityTicketingSeatBinding.inflate(layoutInflater)
}