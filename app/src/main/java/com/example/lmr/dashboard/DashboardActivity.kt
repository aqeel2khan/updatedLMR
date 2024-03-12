package com.example.lmr.dashboard
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.lmr.fragment.BookedFragment
import com.example.ajzoproject.fragment.CreateEventFragment
import com.example.lmr.fragment.DashboardFragment
import com.example.lmr.fragment.ProfileFragment
import com.example.lmr.fragment.SearchFragment
import com.example.lmr.R
import com.example.lmr.databinding.ActivityDashboardBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
class DashboardActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityDashboardBinding
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        mBinding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        bottomNavigation = findViewById(R.id.bottomNavigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_dashboard -> replaceFragment(DashboardFragment())
                R.id.navigation_search -> replaceFragment(SearchFragment())
                R.id.navigation_create_event -> replaceFragment(CreateEventFragment())
                R.id.navigation_booked -> replaceFragment(BookedFragment())
                R.id.navigation_profile -> replaceFragment(ProfileFragment())
            }
            true
        }
        if (savedInstanceState == null) {
            replaceFragment(DashboardFragment())
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}