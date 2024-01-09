package com.example.batchfinal.view.fragment

import androidx.fragment.app.viewModels
import com.example.batchfinal.databinding.FragmentHomeBinding
import com.example.batchfinal.view.BaseFragment
import com.example.batchfinal.viewmodel.AllViewModel
import com.example.batchfinal.viewmodel.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel: AllViewModel by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun initUi() {

    }

    override fun onResume() {
        super.onResume()
        handleHeader(true)
//        handleTitle("Dashboard")
    }

    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)

}