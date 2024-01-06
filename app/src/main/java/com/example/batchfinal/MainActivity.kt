package com.example.batchfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.batchfinal.databinding.ActivityMainBinding
import com.example.batchfinal.utils.makeGone
import com.example.batchfinal.utils.makeVisible
import com.example.batchfinal.view.BaseActivity
import com.example.batchfinal.viewmodel.AllViewModel
import com.example.batchfinal.viewmodel.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val viewModel: AllViewModel by viewModels()
    private lateinit var navController: NavController

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun initUi() {
        navController = findNavController(R.id.main_fragment)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.tvHeading.text = "Batchboard"
        navigateToRootNode(R.id.batch_navigation)
        setUpBottomBar()



//        setupSmoothBottomMenu()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun setUpBottomBar() {
        binding.bottomNavBar.setItemSelected(R.id.home_fragment)
        binding.bottomNavBar.setOnItemSelectedListener {
            when (it) {
                R.id.home_fragment -> {
                    binding.tvHeading.text = "Batchboard"
                    navigateToRootNode(R.id.batch_navigation)
                }
                R.id.workout_fragment -> {
                    binding.tvHeading.text = "Workout Batches"
                    navigateToRootNode(R.id.workout_navigation)

                }
                R.id.meal_fragment -> {
                    binding.tvHeading.text = "Meal Batch"
                    navigateToRootNode(R.id.meal_navigation)
                }
                R.id.shopping_fragment -> {
                    binding.tvHeading.text = "Shopping Batch"
                    navigateToRootNode(R.id.shopping_navigation)
                }
                R.id.scanning_fragment -> {
                    binding.tvHeading.text = "Scanning Batch"
                    navigateToRootNode(R.id.scanning_navigation)
                }
            }
        }
    }

    private fun navigateToRootNode(startDestinationId: Int, bundle: Bundle? = null) {
        val navOptions = NavOptions.Builder()
            .setPopUpTo(startDestinationId, false)
            .build()

        navController.navigate(startDestinationId, bundle, navOptions)
    }

    fun handleHeader(isVisible: Boolean = true, perform: () -> Unit = {}) {
        if (isVisible) {
            binding.headerTitle.makeVisible()
        } else {
            binding.headerTitle.makeGone()
        }
    }

    private fun setupSmoothBottomMenu() {
        val popupMenu = PopupMenu(this, null)
        popupMenu.inflate(R.menu.menu_bottom)
        val menu = popupMenu.menu
        binding.bottomBar.setupWithNavController(menu, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

}