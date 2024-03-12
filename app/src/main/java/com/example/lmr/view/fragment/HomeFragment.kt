package com.example.lmr.view.fragment

import androidx.fragment.app.viewModels
import com.example.lmr.databinding.FragmentHomeBinding
import com.example.lmr.view.BaseFragment
import com.example.lmr.viewmodel.AllViewModel
import com.example.lmr.viewmodel.BaseViewModel
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