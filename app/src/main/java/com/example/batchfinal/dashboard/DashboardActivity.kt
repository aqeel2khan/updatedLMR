package com.example.ajzoproject.dashboard
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ajzoproject.R
import com.example.ajzoproject.databinding.ActivityDashboardBinding
import com.example.ajzoproject.fragment.BookedFragment
import com.example.ajzoproject.fragment.CreateEventFragment
import com.example.ajzoproject.fragment.DashboardFragment
import com.example.ajzoproject.fragment.ProfileFragment
import com.example.ajzoproject.fragment.SearchFragment
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