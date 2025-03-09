package com.rota.barcodequarreader.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.rota.barcodequarreader.R
import com.rota.barcodequarreader.databinding.ActivityMainBinding
import com.rota.barcodequarreader.utils.PreferencesManager

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        
        binding.bottomNav.setupWithNavController(navController)

        // Handle deep links if needed
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.scannerFragment -> binding.bottomNav.isVisible = true
                R.id.historyFragment -> binding.bottomNav.isVisible = true
                R.id.settingsFragment -> binding.bottomNav.isVisible = true
                else -> binding.bottomNav.isVisible = false
            }
        }
    }
}