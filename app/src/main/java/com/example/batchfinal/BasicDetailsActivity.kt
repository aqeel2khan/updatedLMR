package com.example.ajzoproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.ajzoproject.databinding.ActivityBasicDetailsBinding


class BasicDetailsActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityBasicDetailsBinding
    private var isPrivateEvent = true
    private var isPublicEvent = true
    private var isFreeEvent = true
    private var isPaidEvent = true
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_details)
        mBinding = ActivityBasicDetailsBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        mBinding.publicEvent.setOnClickListener {
            isPrivateEvent = !isPrivateEvent
            mBinding.publicEvent.isChecked = isPrivateEvent
        }

        mBinding.privateEvent.setOnClickListener {
            isPublicEvent = !isPublicEvent
            mBinding.privateEvent.isChecked = isPublicEvent
        }
        mBinding.freeEvent.setOnClickListener {
            isFreeEvent = !isFreeEvent
            mBinding.freeEvent.isChecked = isFreeEvent
        }
        mBinding.paidEvent.setOnClickListener {
            isPaidEvent = !isPaidEvent
            mBinding.paidEvent.isChecked = isPaidEvent
        }

        customSpinnerChooseEventCategory();
        customSpinnerEvent();
        customSpinnerTotalMaximumCapacity();
        customSpinnerAgeGroup();

        mBinding.saveAndContinueButtonBasic.setOnClickListener {
            startActivity(Intent(this, EventDescriptionActivity::class.java))
        }
    }


    private fun customSpinnerEvent() {
        val items =
            arrayOf("Marriage 1", "Party 2", "Birthday  3", "Anniversary 4", "Rewards Party 5")
        val adapter = ArrayAdapter(this, R.layout.custom_dropdown_item, items)
        mBinding.customSpinner1.adapter = adapter
    }

    private fun customSpinnerChooseEventCategory() {
        val items =
            arrayOf("Dawat Waleema1", "Reception ", "Price Reward", "Annual Party", "Eid Party")
        val adapter = ArrayAdapter(this, R.layout.custom_dropdown_item, items)
        mBinding.customSpinner2.adapter = adapter
    }

    private fun customSpinnerTotalMaximumCapacity() {
        val items = arrayOf("100-200", "200-300 ", "300-400", "400-500")
        val adapter = ArrayAdapter(this, R.layout.custom_dropdown_item, items)
        mBinding.customSpinner3.adapter = adapter
    }


    private fun customSpinnerAgeGroup() {
        val items = arrayOf("18", "19 ", "20", "21")
        val adapter = ArrayAdapter(this, R.layout.custom_dropdown_item, items)
        mBinding.customSpinner4.adapter = adapter
    }


}