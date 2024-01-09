package com.example.batchfinal.view.activity

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import com.example.batchfinal.R
import com.example.batchfinal.databinding.ActivityDateTime3Binding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.BaseViewModel
import com.example.batchfinal.viewmodel.DateTimeViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class DateTime3Activity() : BaseActivity<ActivityDateTime3Binding>() {
    private val viewModel: DateTimeViewModel by viewModels()
    override fun getViewModel(): BaseViewModel {
        return  viewModel
    }
    override fun initUi() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        detailsTextView.text = "Date & Time"

        supportActionBar!!.setDisplayShowTitleEnabled(false)
        binding.tvsingledayevent.setOnClickListener {
            binding.tvrecurringevent.setBackgroundResource(R.drawable.circle_shap_allo)
            binding.tvsingledayevent.setBackgroundResource(R.drawable.circel_shep_white)
        }
        binding.tvrecurringevent.setOnClickListener {
            binding.tvrecurringevent.setBackgroundResource(R.drawable.circel_shep_white)
            binding.tvsingledayevent.setBackgroundResource(R.drawable.circle_shap_allo)
        }

        binding.imenddata.setOnClickListener {
            openCalendar2()
        }
        binding.imdateicon.setOnClickListener {
            openCalendar()
        }
        binding.ivStartTime.setOnClickListener {
            showTimeDialog()

        }
        binding.imendtimeicon.setOnClickListener {
            showTimeDialog2()
        }
        binding.saveAndContinueButtonDateTime.setOnClickListener {
            startActivity(Intent(this, LocationActivity::class.java))
        }
    }

    override fun getViewBinding()= ActivityDateTime3Binding.inflate(layoutInflater)

    private fun showTimeDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                val date = "/$hourOfDay/$minute"
                binding.tvStartTime.text = date
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
                binding.tvStartTime.text = date
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
                binding.startDateText.text = date

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
                binding.endDate.text = date
            },
            Calendar.getInstance()[Calendar.YEAR],
            Calendar.getInstance()[Calendar.MONTH],
            Calendar.getInstance()[Calendar.DAY_OF_MONTH]
        )
        datePickerDialog.show()
    }
}