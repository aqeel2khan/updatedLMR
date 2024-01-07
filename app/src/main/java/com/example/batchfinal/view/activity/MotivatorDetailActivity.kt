package com.example.batchfinal.view.activity

import android.content.Intent
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batchfinal.R
import com.example.batchfinal.adapter.RecommendedProductListAdapter
import com.example.batchfinal.adapter.WorkoutBatchAdapter
import com.example.batchfinal.databinding.ActivityMotivatorDetailBinding
import com.example.batchfinal.`interface`.PositionItemClickListener
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.AllViewModel
import com.example.batchfinal.viewmodel.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class MotivatorDetailActivity : BaseActivity<ActivityMotivatorDetailBinding>() {
   private val viewModel: AllViewModel by viewModels()

    var courseImg = ArrayList(Arrays.asList(
        R.drawable.ic_arrow, R.drawable.food,
        R.drawable.profile_image, R.drawable.normal_boy)
    )
    var techerName = ArrayList(
        Arrays.asList(
            "Leggings in blue", "Training Top", "Yoga Main in Deep Blue", "Leggings in blue" )
    )
    var profesion = ArrayList(
        Arrays.asList(
            "\$35", "\$35", "\$35", "\$35" )
    )

    var name = ArrayList(
        Arrays.asList(
            "Weight Loss", "Workout Batch", "Workout Batch" )
    )
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun initUi() {
        setAllBatchesAdapter()
        setUpRecommendedProductorAdapter()
        buttonClicks()
        val aniSlide: Animation = AnimationUtils.loadAnimation(applicationContext, R.anim.bottom_top)
        binding.rlMainLayout.startAnimation(aniSlide)
    }

    private fun buttonClicks() {

    }

    private fun setUpRecommendedProductorAdapter() {
        binding.recyclerRecommendedProduct.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerRecommendedProduct.adapter = RecommendedProductListAdapter(this, courseImg,techerName, profesion,
            object : PositionItemClickListener<Int> {
                override fun onPositionItemSelected(item: String, postions: Int) {
//                    startActivity(Intent(this, MotivatorDetailActivity::class.java))
                }
            })
    }

    private fun setAllBatchesAdapter() {
        binding.recyclerBatches.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerBatches.adapter = WorkoutBatchAdapter(this, name, object : PositionItemClickListener<Int>{
            override fun onPositionItemSelected(item: String, postions: Int) {
                startActivity(Intent(this@MotivatorDetailActivity, WeightLossActivity::class.java))
            }

        })
    }

    override fun getViewBinding() = ActivityMotivatorDetailBinding.inflate(layoutInflater)
}