package com.rezaei.ischool.activities

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigationrail.NavigationRailView
import com.rezaei.ischool.R
import com.rezaei.ischool.databinding.ActivityMainBinding
import com.rezaei.ischool.fragments.dashboard.DashboardFragment
import com.rezaei.ischool.fragments.schedule.ScheduleFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.navigation_rail, DashboardFragment(), "InboxFragment")
        ft.commit()

        val navigationRail: NavigationRailView = findViewById(R.id.navigation_rail)
        navigationRail.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.dashboard -> {
                    val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                    ft.replace(R.id.navigation_rail, DashboardFragment(), "InboxFragment")
                    ft.commit()
                    Toast.makeText(this, "Files", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.schedule -> {
                    val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                    ft.replace(R.id.navigation_rail, ScheduleFragment(), "InboxFragment")
                    ft.commit()
                    true
                } else -> false
            }
        }

    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.navigation_rail)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}