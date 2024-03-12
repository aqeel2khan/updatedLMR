package com.example.lmr.view.fragment

import androidx.fragment.app.viewModels
import com.example.lmr.R
import com.example.lmr.databinding.FragmentWorkOutBinding
import com.example.lmr.adapter.TabFragmentAdapter
import com.example.lmr.view.BaseFragment
import com.example.lmr.viewmodel.AllViewModel
import com.example.lmr.viewmodel.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WorkOutFragment : BaseFragment<FragmentWorkOutBinding>() {
    private val viewModel: AllViewModel by viewModels()
    private var adapterViewPager: TabFragmentAdapter? = null

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun initUi() {
        buttonClicks()

        setUpTablayoutWithViewPager()
    }

    private fun setUpTablayoutWithViewPager() {
        adapterViewPager = TabFragmentAdapter(requireActivity().supportFragmentManager)
        adapterViewPager!!.addFragment(BatchesFragment(), requireActivity().resources.getString(R.string.txt_batch))
        adapterViewPager!!.addFragment(MotivationsFragment(), requireActivity().resources.getString(R.string.txt_motivations))
        binding.viewPager.adapter = adapterViewPager
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    private fun buttonClicks() {
    }


    override fun getViewBinding() = FragmentWorkOutBinding.inflate(layoutInflater)

    override fun onResume() {
        super.onResume()
        handleHeader(true)
//        handleTitle("Dashboard")
    }
}