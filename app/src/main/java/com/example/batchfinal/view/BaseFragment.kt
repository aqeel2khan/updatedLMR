package com.example.batchfinal.view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.batchfinal.view.activity.MainActivity
import com.example.batchfinal.utils.AppSharedPreferences
import com.example.batchfinal.utils.LoaderFragment
import com.example.batchfinal.viewmodel.BaseViewModel
import javax.inject.Inject

abstract class BaseFragment<B : ViewBinding> : Fragment() {
    @Inject
    protected lateinit var sharedPreferences: AppSharedPreferences
    protected lateinit var binding: B
    private var spinningDialog: Dialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding()
        initializeCommonObservers(getViewModel())
        initUi()
        return binding.root
    }
    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
//    fun showLoader() {
//        try {
//            LoaderFragment.showLoader(requireActivity().supportFragmentManager)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }
//    fun hideLoader() {
//        try {
//            LoaderFragment.dismissLoader(requireActivity().supportFragmentManager)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }

    fun showLoader() {
        try {
            LoaderFragment.showLoader(requireActivity().supportFragmentManager)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    fun hideLoader() {
        try {
            LoaderFragment.dismissLoader(requireActivity().supportFragmentManager)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    protected open fun setErrorAndSpinnerObserver(): Boolean {
        return true
    }
    private fun initializeCommonObservers(viewModel: BaseViewModel) {
        if (setErrorAndSpinnerObserver()) {
            viewModel.error.observe(requireActivity(), { message ->
                message?.let(::showError)
            })

            viewModel.spinner.observe(requireActivity(), { loading ->
                if (loading) {
//                    showLoader()
                } else {
//                    hideLoader()
                }
            })
        }
    }
    protected fun handleHeader(isVisible: Boolean = true, perform: () -> Unit = {}){
        (requireActivity() as? MainActivity)?.handleHeader(isVisible, perform)
    }

//    protected fun handleTitle(headerTitle: String, perform: () -> Unit = {}){
//        (requireActivity() as? MainActivity)?.handleTitle(headerTitle, perform)
//    }

//    protected fun handleBottomBar(isVisible: Boolean = true, perform: () -> Unit = {}){
//        (requireActivity() as? MainActivity)?.handleBottomBar(isVisible, perform)
//    }
    abstract fun getViewModel(): BaseViewModel
    abstract fun initUi()
    abstract fun getViewBinding(): B
}