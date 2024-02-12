package com.example.batchfinal.view.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.batchfinal.R
import com.example.batchfinal.adapter.CustomSpinerEventCategoryAdapter
import com.example.batchfinal.databinding.ActivityBasicDetailsBinding
import com.example.batchfinal.model.response.EventCategory
import com.example.batchfinal.model.response.EventCategoryModelResponse
import com.example.batchfinal.utils.CheckNetworkConnection
import com.example.batchfinal.utils.NetworkErrorResult
//import com.example.batchfinal.utils.snackBarWithRedBackground
import com.example.batchfinal.view.BaseFragment
import com.example.batchfinal.view.activity.EventDescriptionActivity
import com.example.batchfinal.viewmodel.BaseViewModel
import com.example.batchfinal.viewmodel.BasicDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BasicDetailsFragment : BaseFragment<ActivityBasicDetailsBinding>() {
    private lateinit var customEventCategorySpinner: CustomSpinerEventCategoryAdapter
    private val viewModel: BasicDetailViewModel by viewModels()
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }
    override fun getViewBinding() = ActivityBasicDetailsBinding.inflate(layoutInflater)
    private var isPrivateEvent = true
    private var isPublicEvent = true
    private var isFreeEvent = true
    private var isPaidEvent = true
    override fun initUi() {
//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
//        supportActionBar!!.setDisplayShowTitleEnabled(false)

        binding.publicEvent.setOnClickListener {
            isPrivateEvent = !isPrivateEvent
            binding.publicEvent.isChecked = isPrivateEvent
        }
        binding.privateEvent.setOnClickListener {
            isPublicEvent = !isPublicEvent
            binding.privateEvent.isChecked = isPublicEvent
        }
        binding.freeEvent.setOnClickListener {
            isFreeEvent = !isFreeEvent
            binding.freeEvent.isChecked = isFreeEvent
        }
        binding.paidEvent.setOnClickListener {
            isPaidEvent = !isPaidEvent
            binding.paidEvent.isChecked = isPaidEvent
        }
        customSpinnerChooseEventCategory();
        customSpinnerEvent();
        customSpinnerTotalMaximumCapacity();
        customSpinnerAgeGroup();
        binding.saveAndContinueButtonBasic.setOnClickListener {
            startActivity(Intent(requireActivity(), EventDescriptionActivity::class.java))
        }
        //Todo Call API Get Category Event from Server via API
        servicecategoryeEventApi()
    }

    @SuppressLint("LogNotTimber")
    private fun servicecategoryeEventApi() {


        try {
            if (CheckNetworkConnection.isConnection(binding.root.context, binding.root, true)) {
                showLoader()
                viewModel.getCategoryEvents()

                viewModel.eventcategoryResponse.observe(this){
                    when(it){
                        is NetworkErrorResult.Success->{
                            viewModel.eventcategoryResponse.removeObservers(this)
                            if (viewModel.eventcategoryResponse.hasObservers()) return@observe
                            hideLoader()
                            lifecycleScope.launch {
                                it.let {
                                    val response = it.data
                                //    Log.e("response",response.toString())
                                    if(response!!.success){

                                        if(!response?.data.isNullOrEmpty()){
                                           // setRecylerServices(response.data.reviews)

                                            setDataforCategorySpinner(response?.data)

                                        }else{

                                        }


                                    }else{

                                    }

                                }
                            }
                        }
                        is NetworkErrorResult.Error->{
                            viewModel.eventcategoryResponse.removeObservers(this)
                            if ( viewModel.eventcategoryResponse.hasObservers()) return@observe
                            hideLoader()
                         //   snackBarWithRedBackground(binding.root, MyUtils.errorBody(it.message,binding.root.context))
                        }
                        is NetworkErrorResult.Loading->{
                            hideLoader()
                        }

                        else -> {

                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun setDataforCategorySpinner(listEventCategory: MutableList<EventCategory>?) {

        try {
            customEventCategorySpinner =  CustomSpinerEventCategoryAdapter(requireContext(), listEventCategory)
            binding.customSpinner1.adapter=customEventCategorySpinner
            binding.customSpinner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {

                var categorySelected=     listEventCategory?.get(position)
                } // to close the onItemSelected

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
        } catch (e: Exception) {
           e.printStackTrace()
        }
    }


    private fun customSpinnerEvent() {

//        val adapter = CustomSpinerEventCategoryAdapter(requireContext(), listCategoryEvent)
//        binding.customSpinner1.adapter = adapter
    }
    private fun customSpinnerChooseEventCategory() {
        val items =
            arrayOf("Dawat Waleema1", "Reception ", "Price Reward", "Annual Party", "Eid Party")
        val adapter = ArrayAdapter(requireContext(), R.layout.custom_dropdown_item, items)
        binding.customSpinner2.adapter = adapter
    }
    private fun customSpinnerTotalMaximumCapacity() {
        val items = arrayOf("100-200", "200-300 ", "300-400", "400-500")
        val adapter = ArrayAdapter(requireContext(), R.layout.custom_dropdown_item, items)
        binding.customSpinner3.adapter = adapter
    }
    private fun customSpinnerAgeGroup() {
        val items = arrayOf("18", "19 ", "20", "21")
        val adapter = ArrayAdapter(requireContext(), R.layout.custom_dropdown_item, items)
        binding.customSpinner4.adapter = adapter
    }
}