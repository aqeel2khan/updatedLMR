package com.example.batchfinal.view.activity
import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import com.example.batchfinal.R
import com.example.batchfinal.databinding.ActivityEventDescriptionBinding
import com.example.batchfinal.utils.MyConstant
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.BaseViewModel
import com.example.batchfinal.viewmodel.EventDescriptionViewModel
import com.github.dhaval2404.imagepicker.ImagePicker
import com.in10mServiceMan.ui.viewmodel.out.utils.PermissionKeys
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventDescriptionActivity : BaseActivity<ActivityEventDescriptionBinding>() {
    private val viewModel: EventDescriptionViewModel by viewModels()

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

        requestPermission()

        addImage()
    }

    private fun addImage() {

        binding.addImage.setOnClickListener {
            if(PermissionKeys.checkPermission1(this)){
                ImagePicker.with(this)
                    .crop()	    			//Crop image(Optional), Check Customization for more option
                    .start()
            }else
                requestPermission()  }
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),
            MyConstant.PERMISSION_REQUEST_CODE
        )
    }

    override fun getViewBinding() = ActivityEventDescriptionBinding.inflate(layoutInflater)
}