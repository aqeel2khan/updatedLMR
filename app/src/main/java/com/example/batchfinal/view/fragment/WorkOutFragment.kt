package com.example.batchfinal.view.fragment

import android.graphics.Color
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.batchfinal.R
import com.example.batchfinal.adapter.AllBatchesAdapter
import com.example.batchfinal.adapter.TabFragmentAdapter
import com.example.batchfinal.databinding.FragmentWorkOutBinding
import com.example.batchfinal.view.BaseFragment
import com.example.batchfinal.viewmodel.AllViewModel
import com.example.batchfinal.viewmodel.BaseViewModel
import com.google.android.material.tabs.TabLayout
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
        adapterViewPager = TabFragmentAdapter(activity!!.supportFragmentManager)
        adapterViewPager!!.addFragment(BatchesFragment(), activity!!.resources.getString(R.string.txt_batch))
        adapterViewPager!!.addFragment(MotivationsFragment(), activity!!.resources.getString(R.string.txt_motivations))
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