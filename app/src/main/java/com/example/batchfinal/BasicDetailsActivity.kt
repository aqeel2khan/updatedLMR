package com.example.batchfinal

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import com.example.batchfinal.databinding.ActivityBasicDetailsBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.BaseViewModel
import com.example.batchfinal.viewmodel.BasicDetailViewModel
import com.google.gson.JsonObject
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BasicDetailsActivity : BaseActivity<ActivityBasicDetailsBinding>() {
    private var position_spinner1: Int=0
    private var position_spinner2: Int=0
    private var position_spinneer3:Int=0
    private var position_spinneer4:Int=0

    private val viewModel: BasicDetailViewModel by viewModels()



    override fun getViewModel(): BaseViewModel {
        return viewModel

    }

    override fun getViewBinding() = ActivityBasicDetailsBinding.inflate(layoutInflater)

    private var isPrivateEvent = true
    private var isPublicEvent = true
    private var isFreeEvent = true
    private var isPaidEvent = true
    @SuppressLint("SuspiciousIndentation")
    override fun initUi() {

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        binding.publicEvent.setOnClickListener {
            isPrivateEvent = false
            isPublicEvent = true
            binding.publicEvent.isChecked = isPublicEvent
            binding.privateEvent.isChecked = isPrivateEvent
        }

        binding.privateEvent.setOnClickListener {
            isPrivateEvent = true
            isPublicEvent = false
            binding.privateEvent.isChecked = isPrivateEvent
            binding.publicEvent.isChecked = isPublicEvent
        }
        binding.freeEvent.setOnClickListener {
            isFreeEvent = true
            isPaidEvent = false
            binding.freeEvent.isChecked = isFreeEvent
            binding.paidEvent.isChecked = isPaidEvent
        }
        binding.paidEvent.setOnClickListener {
            isPaidEvent = true
            isFreeEvent = false
            binding.paidEvent.isChecked = isPaidEvent
            binding.paidEvent.isChecked = isPaidEvent
        }

        customSpinnerChooseEventCategory();
        customSpinnerEvent();
        customSpinnerTotalMaximumCapacity();
        customSpinnerAgeGroup();

        binding.saveAndContinueButtonBasic.setOnClickListener {

         var eventName=   binding.eventEditText.text.toString()


            isPublicEvent
            isPrivateEvent
            isPaidEvent
            isFreeEvent
            position_spinner1
            position_spinner2
            position_spinneer3
            position_spinneer4




            startActivity(Intent(this, EventDescriptionActivity::class.java))
        }
        //Todo Call API
       // viewModel.callPostEvent(JsonObject())
    }


    private fun customSpinnerEvent() {
        val items =
            arrayOf("Marriage 1", "Party 2", "Birthday  3", "Anniversary 4", "Rewards Party 5")
        val adapter = ArrayAdapter(this, R.layout.custom_dropdown_item, items)
        binding.customSpinner1.adapter = adapter

        binding.customSpinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
              var  selectedText = items[position]
                position_spinner1= position
                
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    private fun customSpinnerChooseEventCategory() {
        val items =
            arrayOf("Dawat Waleema1", "Reception ", "Price Reward", "Annual Party", "Eid Party")
        val adapter = ArrayAdapter(this, R.layout.custom_dropdown_item, items)
        binding.customSpinner2.adapter = adapter

        binding.customSpinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                var  selectedText = items[position]
                position_spinner2= position

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    private fun customSpinnerTotalMaximumCapacity() {
        val items = arrayOf("100-200", "200-300 ", "300-400", "400-500")
        val adapter = ArrayAdapter(this, R.layout.custom_dropdown_item, items)
        binding.customSpinner3.adapter = adapter


        binding.customSpinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                var  selectedText = items[position]
                position_spinneer3= position

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }


    private fun customSpinnerAgeGroup() {
        val items = arrayOf("18", "19 ", "20", "21")
        val adapter = ArrayAdapter(this, R.layout.custom_dropdown_item, items)
        binding.customSpinner4.adapter = adapter

        binding.customSpinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                var  selectedText = items[position]
                position_spinneer4 = position

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }


}