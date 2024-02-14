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
import com.example.batchfinal.adapter.EventTypeSpinnerAdapter
import com.example.batchfinal.adapter.MaxCapacitySpinnerAdapter
import com.example.batchfinal.databinding.ActivityBasicDetailsBinding
import com.example.batchfinal.model.response.CapacityData
import com.example.batchfinal.model.response.Event
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
    private lateinit var customEventCategorySpinnerAdapter: CustomSpinerEventCategoryAdapter
    private lateinit var customEventTypeSpinnerAdapter: EventTypeSpinnerAdapter
    private lateinit var customMaxCapacitySpinnerAdapter:  MaxCapacitySpinnerAdapter


    private  var eventcategorySelected : EventCategory? = null
    private  var eventTypeSelected : Event? = null
    private var  capacityDataSelected :CapacityData ? = null

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
            isPrivateEvent = false
            isPublicEvent = true
            binding.publicEvent.isChecked = true
            binding.privateEvent.isChecked = false
        }
        binding.privateEvent.setOnClickListener {
            isPublicEvent = false
            isPrivateEvent = true
            binding.privateEvent.isChecked = true
            binding.publicEvent.isChecked = false
        }
        binding.freeEvent.setOnClickListener {
            isFreeEvent = true
            isPaidEvent = false
            binding.freeEvent.isChecked = true
            binding.paidEvent.isChecked = false
        }
        binding.paidEvent.setOnClickListener {
            isFreeEvent = false
            isPaidEvent = true
            binding.paidEvent.isChecked = true
            binding.freeEvent.isChecked = false
        }
        customSpinnerAgeGroup();
        binding.saveAndContinueButtonBasic.setOnClickListener {
            startActivity(Intent(requireActivity(), EventDescriptionActivity::class.java))
        }
        //Todo Call API Get Category Event from Server via API
        servicecategoryeEventApi()

        serviceeventType()
        serviceMaximumCapacity()


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

                                    //    response.data.

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

    private fun serviceMaximumCapacity() {


        try {
            if (CheckNetworkConnection.isConnection(binding.root.context, binding.root, true)) {
                //   showLoader()
                viewModel.getMaximumCapacity()

                viewModel.maximumCapacityResponse.observe(this){
                    when(it){
                        is NetworkErrorResult.Success->{
                            viewModel.maximumCapacityResponse.removeObservers(this)
                            if (viewModel.maximumCapacityResponse.hasObservers()) return@observe
                            //     hideLoader()
                            lifecycleScope.launch {
                                it.let {
                                    val response = it.data
                                    //    Log.e("response",response.toString())
                                    if(response!!.success){

                                        if(!response?.data.isNullOrEmpty()){
                                            // setRecylerServices(response.data.reviews)

                                            setDataforMaxCapacitySpinner(response?.data)

                                        }else{

                                        }

                                        //    response.data.

                                    }else{

                                    }

                                }
                            }
                        }
                        is NetworkErrorResult.Error->{
                            viewModel.eventcategoryResponse.removeObservers(this)
                            if ( viewModel.eventcategoryResponse.hasObservers()) return@observe
                            //   hideLoader()
                            //   snackBarWithRedBackground(binding.root, MyUtils.errorBody(it.message,binding.root.context))
                        }
                        is NetworkErrorResult.Loading->{
                            //  hideLoader()
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

    private fun setDataforMaxCapacitySpinner(data: MutableList<CapacityData>?) {

        try {

            val addHint = CapacityData(-1,"MAXIMUM")
            data!!.add(0,addHint)
            customMaxCapacitySpinnerAdapter =  MaxCapacitySpinnerAdapter(requireContext(), data)
            binding.customSpinner3.adapter=customMaxCapacitySpinnerAdapter
            binding.customSpinner3?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {

                    capacityDataSelected=     data?.get(position)
                } // to close the onItemSelected

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    private fun serviceeventType() {


        try {
            if (CheckNetworkConnection.isConnection(binding.root.context, binding.root, true)) {
             //   showLoader()
                viewModel.getEventsType()

                viewModel.eventTypeResponse.observe(this){
                    when(it){
                        is NetworkErrorResult.Success->{
                            viewModel.eventTypeResponse.removeObservers(this)
                            if (viewModel.eventTypeResponse.hasObservers()) return@observe
                       //     hideLoader()
                            lifecycleScope.launch {
                                it.let {
                                    val response = it.data
                                    //    Log.e("response",response.toString())
                                    if(response!!.success){

                                        if(!response?.data.isNullOrEmpty()){
                                            // setRecylerServices(response.data.reviews)

                                            setDataforEventTypeSpinner(response?.data)

                                        }else{

                                        }

                                        //    response.data.

                                    }else{

                                    }

                                }
                            }
                        }
                        is NetworkErrorResult.Error->{
                            viewModel.eventcategoryResponse.removeObservers(this)
                            if ( viewModel.eventcategoryResponse.hasObservers()) return@observe
                         //   hideLoader()
                            //   snackBarWithRedBackground(binding.root, MyUtils.errorBody(it.message,binding.root.context))
                        }
                        is NetworkErrorResult.Loading->{
                          //  hideLoader()
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

    private fun setDataforEventTypeSpinner(data: MutableList<Event>?) {
        try {
            val addHint = Event(-1,"TYPE OF EVENT","","EN")
            data!!.add(0,addHint)
            customEventTypeSpinnerAdapter =  EventTypeSpinnerAdapter(requireContext(), data)
            binding.customSpinner1.adapter=customEventTypeSpinnerAdapter
            binding.customSpinner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {

                    eventTypeSelected=     data?.get(position)
                } // to close the onItemSelected

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    private fun setDataforCategorySpinner(listEventCategory: MutableList<EventCategory>?) {

        try {
            val addHint = EventCategory(-1,"CHOOSE CATEGORY","","EN")
            listEventCategory!!.add(0,addHint)
            customEventCategorySpinnerAdapter =  CustomSpinerEventCategoryAdapter(requireContext(), listEventCategory)
            binding.customSpinner2.adapter=customEventCategorySpinnerAdapter
            binding.customSpinner2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {

                 eventcategorySelected=     listEventCategory?.get(position)
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

    private fun customSpinnerAgeGroup() {
        val items = arrayOf("18", "19 ", "20", "21")
        val adapter = ArrayAdapter(requireContext(), R.layout.custom_dropdown_item, items)
        binding.customSpinner4.adapter = adapter
    }
}