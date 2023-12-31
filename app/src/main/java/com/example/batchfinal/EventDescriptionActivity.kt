package com.example.ajzoproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.ajzoproject.databinding.ActivityEventDescriptionBinding

class EventDescriptionActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityEventDescriptionBinding
    @SuppressLint("MissingInflatedId", "SetTextI18n", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_description)
        mBinding = ActivityEventDescriptionBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayShowTitleEnabled(false)
        mBinding.saveAndContinueButton.setOnClickListener {
            startActivity(Intent(this,DateTime3Activity::class.java))
        }
        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        detailsTextView.text = "More Details"
    }
}