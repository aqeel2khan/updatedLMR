package com.example.ajzoproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.batchfinal.R
import com.example.batchfinal.databinding.ActivityBasicDetailsBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.AllViewModel
import com.example.batchfinal.viewmodel.BaseViewModel
import com.example.batchfinal.viewmodel.BasicDetailViewModel
import com.google.gson.JsonObject
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONObject

@AndroidEntryPoint
class BasicDetailsActivity : BaseActivity<ActivityBasicDetailsBinding>() {
    private val viewModel: BasicDetailViewModel by viewModels()

//    private lateinit var mBinding: ActivityBasicDetailsBinding
    private var isPrivateEvent = true
    private var isPublicEvent = true
    private var isFreeEvent = true
    private var isPaidEvent = true
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_basic_details)
//        mBinding = ActivityBasicDetailsBinding.inflate(layoutInflater)
//        setContentView(mBinding.root)
//
//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
//        supportActionBar!!.setDisplayShowTitleEnabled(false)
//
//        mBinding.publicEvent.setOnClickListener {
//            isPrivateEvent = !isPrivateEvent
//            mBinding.publicEvent.isChecked = isPrivateEvent
//        }
//
//        mBinding.privateEvent.setOnClickListener {
//            isPublicEvent = !isPublicEvent
//            mBinding.privateEvent.isChecked = isPublicEvent
//        }
//        mBinding.freeEvent.setOnClickListener {
//            isFreeEvent = !isFreeEvent
//            mBinding.freeEvent.isChecked = isFreeEvent
//        }
//        mBinding.paidEvent.setOnClickListener {
//            isPaidEvent = !isPaidEvent
//            mBinding.paidEvent.isChecked = isPaidEvent
//        }
//
//        customSpinnerChooseEventCategory();
//        customSpinnerEvent();
//        customSpinnerTotalMaximumCapacity();
//        customSpinnerAgeGroup();
//
//        mBinding.saveAndContinueButtonBasic.setOnClickListener {
//            startActivity(Intent(this, EventDescriptionActivity::class.java))
//        }
//    }

    override fun getViewModel(): BaseViewModel {
        return viewModel

    }
    override fun getViewBinding() = ActivityBasicDetailsBinding.inflate(layoutInflater)


    override fun initUi() {

                val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        binding.publicEvent.setOnClickListener {
            isPrivateEvent = !isPrivateEvent
            binding.publicEvent.isChecked = isPrivateEvent
        }

        binding.privateEvent.setOnClickListener {
            isPublicEvent = !isPublicEvent
            binding.privateEvent.isChecked = isPublicEvent
        }
        binding.freeEvent.setOnClickListener {
            isFreeEvent = !isFreeEvent
            binding.freeEvent.isChecked = isFreeEvent
        }
        binding.paidEvent.setOnClickListener {
            isPaidEvent = !isPaidEvent
            binding.paidEvent.isChecked = isPaidEvent
        }

        customSpinnerChooseEventCategory();
        customSpinnerEvent();
        customSpinnerTotalMaximumCapacity();
        customSpinnerAgeGroup();

        binding.saveAndContinueButtonBasic.setOnClickListener {
            startActivity(Intent(this, EventDescriptionActivity::class.java))
        }
        //Todo Call API

        viewModel.callPostEvent(JsonObject())
    }




    private fun customSpinnerEvent() {
        val items =
            arrayOf("Marriage 1", "Party 2", "Birthday  3", "Anniversary 4", "Rewards Party 5")
        val adapter = ArrayAdapter(this, R.layout.custom_dropdown_item, items)
        binding.customSpinner1.adapter = adapter
    }

    private fun customSpinnerChooseEventCategory() {
        val items =
            arrayOf("Dawat Waleema1", "Reception ", "Price Reward", "Annual Party", "Eid Party")
        val adapter = ArrayAdapter(this, R.layout.custom_dropdown_item, items)
        binding.customSpinner2.adapter = adapter
    }

    private fun customSpinnerTotalMaximumCapacity() {
        val items = arrayOf("100-200", "200-300 ", "300-400", "400-500")
        val adapter = ArrayAdapter(this, R.layout.custom_dropdown_item, items)
        binding.customSpinner3.adapter = adapter
    }


    private fun customSpinnerAgeGroup() {
        val items = arrayOf("18", "19 ", "20", "21")
        val adapter = ArrayAdapter(this, R.layout.custom_dropdown_item, items)
        binding.customSpinner4.adapter = adapter
    }


}