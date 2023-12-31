package com.example.ajzoproject
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.batchfinal.R
import com.example.batchfinal.databinding.ActivityEjzoBinding

class EjzoActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityEjzoBinding
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejzo)

        mBinding = ActivityEjzoBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.personalTextView.setOnClickListener {
            mBinding.personalTextView.setBackgroundResource(R.drawable.circle_shap_allo)
            mBinding.personalTextView.setTextColor(R.color.blue)
            mBinding.businessTextView.setBackgroundResource(R.drawable.circle_shap)
            mBinding.businessTextView.setTextColor(R.color.grey)
        }
        mBinding.businessTextView.setOnClickListener {
            mBinding.businessTextView.setBackgroundResource(R.drawable.circle_shap_allo)
            mBinding.businessTextView.setTextColor(R.color.blue)
            mBinding.personalTextView.setBackgroundResource(R.drawable.circle_shap)
            mBinding.personalTextView.setTextColor(R.color.grey)
        }

        mBinding.loginButton.setOnClickListener {
            val intentObj = Intent(this, BasicDetailsActivity::class.java)
            val numberType = mBinding.numberEditText.text.toString()
            val countryCode = mBinding.countryCodeText.text.toString()
            intentObj.putExtra("number", numberType)
            intentObj.putExtra("CountryCode", countryCode)
            startActivity(intentObj)
        }
    }
}