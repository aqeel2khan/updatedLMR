package com.example.ajzoproject

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.batchfinal.R
import com.example.batchfinal.databinding.ActivityTickeetingSeatDetails1Binding
import java.util.Calendar

@Suppress("UNREACHABLE_CODE")
class TicketingSeatDetailsActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityTickeetingSeatDetails1Binding

    @SuppressLint("SuspiciousIndentation", "MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tickeeting_seat_details1)
        mBinding = ActivityTickeetingSeatDetails1Binding.inflate(layoutInflater)
        setContentView(mBinding.root)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        detailsTextView.text = "Ticketing/Seating"
        mBinding.tvFreeText.setOnClickListener {
            mBinding.tvFreeText.setBackgroundResource(R.drawable.circel_shep_white)
            mBinding.tvPaidText.setBackgroundResource(R.drawable.circle_shap_allo)
        }
        mBinding.tvPaidText.setOnClickListener {
            mBinding.tvFreeText.setBackgroundResource(R.drawable.circle_shap_allo)
            mBinding.tvPaidText.setBackgroundResource(R.drawable.circel_shep_white)
        }

        mBinding.ticketsSalesStartDateRelative.setOnClickListener {
            openCalendar2()
        }

        mBinding.startTimeSeat.setOnClickListener {
            showTimeDialog3()
        }
        mBinding.endDateLableRelative.setOnClickListener {
            openCalendar3()
        }
        mBinding.endTimeLableRelative.setOnClickListener {
            showTimeDialog4()
        }
        mBinding.saveAndContinueButtonSeat.setOnClickListener {
            startActivity(Intent(this, TicketingSeatActivity::class.java))
//            val checkStatus = validation()
//            if (checkStatus) {
//            }
        }
    }

    private fun openCalendar2() {
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val date = "$dayOfMonth/$year/$month"
                mBinding.ticketSalesStartDateText.text = date
            },
            Calendar.getInstance()[Calendar.YEAR],
            Calendar.getInstance()[Calendar.MONTH],
            Calendar.getInstance()[Calendar.DAY_OF_MONTH]
        )
        datePickerDialog.show()
    }
    private fun openCalendar3() {
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val date = "$dayOfMonth/$year/$month"
                mBinding.endDateSaleTextView.text = date
            },
            Calendar.getInstance()[Calendar.YEAR],
            Calendar.getInstance()[Calendar.MONTH],
            Calendar.getInstance()[Calendar.DAY_OF_MONTH]
        )
        datePickerDialog.show()
    }


    private fun showTimeDialog4() {
        val timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                val date = "$hourOfDay-$minute"
                mBinding.endTimeSaleTextView.text = date
            },
            0,
            0,
            true
        )
        timePickerDialog.show()
    }
    private fun showTimeDialog3() {
        val timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                val date = "$hourOfDay-$minute"
                mBinding.salesStarTimeTextView.text = date
            },
            0,
            0,
            true
        )
        timePickerDialog.show()
    }


    private fun validation(): Boolean {
        val saleEndTime = mBinding.endTimeSaleTextView.text.toString()
        val vipSeat = mBinding.vipSeatsTextView.text.toString()
        val quantity = mBinding.quantityEditText.text.toString()
        val saleEndDate = mBinding.endTimeSaleTextView.text.toString()
        val salStartDate = mBinding.tvTicketSalesStartDate.text.toString()
        val salStarTime = mBinding.salesStarTimeTextView.text.toString()
        val endDateSale = mBinding.endDateSaleTextView.text.toString()
        val endTimeSale = mBinding.endTimeSaleTextView.text.toString()
        if (TextUtils.isEmpty(endTimeSale)) {
            Toast.makeText(this, "Set Time", Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(endDateSale)) {
            Toast.makeText(this, "Set Date", Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(salStarTime)) {
            Toast.makeText(this, "Set Time", Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(salStartDate)) {
            Toast.makeText(this, "Set Date", Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(saleEndDate)) {
            Toast.makeText(this, "Ticket Sale End Date", Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(vipSeat)) {
            Toast.makeText(this, "VIP Seat is Empty", Toast.LENGTH_SHORT).show()
            return false
        } else if (TextUtils.isEmpty(quantity)) {
            Toast.makeText(this, "Quantity   is Empty", Toast.LENGTH_SHORT).show()
            return false
        }else if (TextUtils.isEmpty(saleEndTime)) {
            Toast.makeText(this, "Select Date", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }
        return false
    }
}