package com.example.ajzoproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.batchfinal.R

import com.example.batchfinal.databinding.ActivityTicketingSeatBinding

class TicketingSeatActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityTicketingSeatBinding
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticketing_seat)
        mBinding  = ActivityTicketingSeatBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        detailsTextView.text = "Ticketing/ Seat Details"

        val spinner=findViewById<Spinner>(R.id.VisibilitySpinner)
        val array= arrayListOf("Visible","Not Visible")
        spinner.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,array)

        mBinding.addbttn.setOnClickListener {
            startActivity(Intent(this, PreviewsActivity::class.java))
        }
    }
}