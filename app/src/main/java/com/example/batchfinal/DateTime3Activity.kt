package com.example.ajzoproject

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.batchfinal.R
import com.example.batchfinal.databinding.ActivityDateTime3Binding
import java.util.Calendar


class DateTime3Activity() : AppCompatActivity() {
    private lateinit var mBinding: ActivityDateTime3Binding
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_time3)
        mBinding = ActivityDateTime3Binding.inflate(layoutInflater)
        setContentView(mBinding.root)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        detailsTextView.text = "Date & Time"

        supportActionBar!!.setDisplayShowTitleEnabled(false)
        mBinding.tvsingledayevent.setOnClickListener {
            mBinding.tvrecurringevent.setBackgroundResource(R.drawable.circle_shap_allo)
            mBinding.tvsingledayevent.setBackgroundResource(R.drawable.circel_shep_white)
        }
        mBinding.tvrecurringevent.setOnClickListener {
            mBinding.tvrecurringevent.setBackgroundResource(R.drawable.circel_shep_white)
            mBinding.tvsingledayevent.setBackgroundResource(R.drawable.circle_shap_allo)
        }

        mBinding.imenddata.setOnClickListener {
            openCalendar2()
        }
        mBinding.imdateicon.setOnClickListener {
            openCalendar()
        }
        mBinding.ivStartTime.setOnClickListener {
            showTimeDialog()

        }
        mBinding.imendtimeicon.setOnClickListener {
            showTimeDialog2()
        }
        mBinding.saveAndContinueButtonDateTime.setOnClickListener {
            startActivity(Intent(this, LocationActivity::class.java))
        }
    }

    private fun showTimeDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
             { _, hourOfDay, minute ->
                val date = "/$hourOfDay/$minute"
                 mBinding.tvStartTime.text = date
            },
            0,
            0,
            true
        )
        timePickerDialog.show()
    }

    private fun showTimeDialog2() {
        val timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                val date = "/$hourOfDay/$minute"
                mBinding.tvStartTime.text = date
            },
            0,
            0,
            true
        )
        timePickerDialog.show()
    }


    private fun openCalendar() {
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val date = "$year/$month/$dayOfMonth"
                mBinding.startDateText.text = date

            },
            Calendar.getInstance()[Calendar.YEAR],
            Calendar.getInstance()[Calendar.MONTH],
            Calendar.getInstance()[Calendar.DAY_OF_MONTH]
        )
        datePickerDialog.show()
    }

    private fun openCalendar2() {
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val date = "$year/$month/$dayOfMonth"
                mBinding.endDate.text = date
            },
            Calendar.getInstance()[Calendar.YEAR],
            Calendar.getInstance()[Calendar.MONTH],
            Calendar.getInstance()[Calendar.DAY_OF_MONTH]
        )
        datePickerDialog.show()
    }


}





