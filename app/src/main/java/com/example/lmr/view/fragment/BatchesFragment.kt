package com.example.lmr.view.fragment

import android.content.Intent
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lmr.databinding.FragmentBatchesBinding
import com.example.lmr.`interface`.PositionItemClickListener
import com.example.lmr.view.BaseFragment
import com.example.lmr.view.activity.WeightLossBatchActivity
import com.example.lmr.viewmodel.AllViewModel
import com.example.lmr.viewmodel.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class BatchesFragment : BaseFragment<FragmentBatchesBinding>() {
    private val viewModel: AllViewModel by viewModels()
    var name = ArrayList(
        Arrays.asList(
            "Workout Batch", "Weight Loss", "Workout Batch" )
    )
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun initUi() {
        setAllBatchesAdapter()
    }

    private fun setAllBatchesAdapter() {
        binding.recyclerBatches.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerBatches.adapter = AllBatchesAdapter(context, name, object : PositionItemClickListener<Int>{
            override fun onPositionItemSelected(item: String, postions: Int) {
                activity!!.startActivity(Intent(requireContext(), WeightLossBatchActivity::class.java))
            }
        })
    }
    override fun getViewBinding() = FragmentBatchesBinding.inflate(layoutInflater)

}