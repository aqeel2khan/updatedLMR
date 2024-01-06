package com.example.batchfinal
import android.annotation.SuppressLint
import android.content.Intent
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import com.example.ajzoproject.DateTime3Activity
import com.example.batchfinal.databinding.ActivityEventDescriptionBinding
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.BaseViewModel
import com.example.batchfinal.viewmodel.BasicDetailViewModel

class EventDescriptionActivity : BaseActivity<ActivityEventDescriptionBinding>() {
    private val viewModel: BasicDetailViewModel by viewModels()

//    private lateinit var mBinding: ActivityEventDescriptionBinding
//    @SuppressLint("MissingInflatedId", "SetTextI18n", "WrongViewCast")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_event_description)
//        mBinding = ActivityEventDescriptionBinding.inflate(layoutInflater)
//        setContentView(mBinding.root)
//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
//
//        supportActionBar!!.setDisplayShowTitleEnabled(false)
//        mBinding.saveAndContinueButton.setOnClickListener {
//            startActivity(Intent(this,DateTime3Activity::class.java))
//        }
//        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
//        detailsTextView.text = "More Details"
//    }

    override fun getViewModel(): BaseViewModel {
        return  viewModel
    }

    @SuppressLint("SetTextI18n")
    override fun initUi() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayShowTitleEnabled(false)
        binding.saveAndContinueButton.setOnClickListener {
            startActivity(Intent(this, DateTime3Activity::class.java))
        }
        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        detailsTextView.text = "More Details"
    }

    override fun getViewBinding() = ActivityEventDescriptionBinding.inflate(layoutInflater)
}