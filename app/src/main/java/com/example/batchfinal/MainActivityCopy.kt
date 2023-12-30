package com.example.batchfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
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
class MainActivityCopy : BaseActivity<ActivityMainBinding>() {
    private val viewModel: AllViewModel by viewModels()
    private lateinit var navController: NavController

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun initUi() {
        navController = findNavController(R.id.main_fragment)
//        setupActionBarWithNavController(navController)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_fragment) as NavHostFragment
        navController = navHostFragment.navController


        setupSmoothBottomMenu()
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