package com.example.lmr.view.fragment

import android.content.Intent
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lmr.databinding.FragmentMotivationsBinding
import com.example.lmr.R
import com.example.lmr.adapter.MotivatorListAdapter
import com.example.lmr.`interface`.PositionItemClickListener
import com.example.lmr.view.BaseFragment
import com.example.lmr.viewmodel.AllViewModel
import com.example.lmr.viewmodel.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList


@AndroidEntryPoint
class MotivationsFragment : BaseFragment<FragmentMotivationsBinding>() {
    private val viewModel: AllViewModel by viewModels()

    var courseImg = ArrayList(Arrays.asList(
            R.drawable.profile_girl, R.drawable.normal_boy,
            R.drawable.profile_image, R.drawable.profile_girl, R.drawable.normal_boy,
        R.drawable.profile_image)
    )
    var techerName = ArrayList(
        Arrays.asList(
            "Bessie Cooper", "Leslie Alexander", "Jenny Wilson", "Bessie Cooper", "Leslie Alexander", "Jenny Wilson" )
    )
    var profesion = ArrayList(
        Arrays.asList(
            "Yoga, pilates", "Cardio stretching", "Mobility", "Yoga, pilates", "Cardio stretching", "Mobility" )
    )


    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun initUi() {
        setMotivatorListAdapter(courseImg, techerName, profesion)
    }

    private fun setMotivatorListAdapter(courseImg: java.util.ArrayList<Int>, techerName: java.util.ArrayList<String>, profesion: java.util.ArrayList<String>) {
        binding.recyclerMotivator.layoutManager = GridLayoutManager(requireActivity(), 2)
        binding.recyclerMotivator.adapter = MotivatorListAdapter(requireContext(), courseImg,techerName, profesion,
            object : PositionItemClickListener<Int>{
                override fun onPositionItemSelected(item: String, postions: Int) {
                    activity!!.startActivity(Intent(context, MotivatorDetailActivity::class.java))
                }
            })
    }

    override fun getViewBinding() = FragmentMotivationsBinding.inflate(layoutInflater)
}