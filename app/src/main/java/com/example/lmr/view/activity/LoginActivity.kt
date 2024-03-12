package com.example.lmr.view.activity

import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import com.example.lmr.R
import com.example.lmr.custom.CustomToast.Companion.showToast
import com.example.lmr.databinding.ActivityLoginBinding
import com.example.lmr.view.BaseActivity
import com.example.lmr.viewmodel.AllViewModel
import com.example.lmr.viewmodel.BaseViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    private val viewModel: AllViewModel by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun initUi() {
       buttonClicks()
    }

    private fun buttonClicks() {
        binding.signButton.setOnClickListener {
            startActivity(Intent(Intent(this, VerificationActivity::class.java)))
        }
        binding.termsCondition.setOnClickListener {  val bottomSheetDialog = BottomSheetDialog(this)
            val bottomSheetView: View = layoutInflater.inflate(R.layout.terms_conditions, null)
            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
            bottomSheetDialog.show()
            val closeButton = bottomSheetView.findViewById<Button>(R.id.agreeAndContinueButton)
            closeButton.setOnClickListener {
                bottomSheetDialog.dismiss()
                showToast("you are agree this condition")
            } }

    }

    override fun getViewBinding() = ActivityLoginBinding.inflate(layoutInflater)

    private fun setDividerWidth(divider: View) {
        val windowManager = windowManager
        val display = windowManager.defaultDisplay
        val screenWidth = display.width
        divider.layoutParams.width = screenWidth / 4.1.toInt()
        divider.requestLayout()
    }
}