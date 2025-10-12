package com.eco.androidtutorial

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.eco.androidtutorial.databinding.ActivityMainBinding
import com.eco.androidtutorial.lifecycle.LifecycleExampleActivity
import com.eco.androidtutorial.lifecycle.viewmodel.DashboardActivity
import com.eco.androidtutorial.managementbackstack.manifestattributes.launchmode.LaunchModeExampleActivity
import com.eco.androidtutorial.registerforactivityresult.common.RegisterForActivityResultExampleActivity
import com.eco.androidtutorial.registerforactivityresult.permission.SelectImageActivity
import com.eco.androidtutorial.senddatabetweenactivity.SenderActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            btnNavigateToDashboard.setOnClickListener {
                navigateToDashboardActivity()
            }
            btnNavigateToLifecycleExample.setOnClickListener {
                navigateToLifecycleExampleActivity()
            }
            btnNavigateToLaunchMode.setOnClickListener {
                navigateToLaunchModeActivity()
            }
            btnNavToSenderDataActivity.setOnClickListener {
                navigateToSenderDataActivity()
            }
            btnNavToRegisterforactivityresult.setOnClickListener {
                navigateToRegisterForActivityResultActivity()
            }
            btnNavigateSelectImage.setOnClickListener {
                navigateToSelectImageActivity()
            }
        }
    }

    private fun navigateToDashboardActivity() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToLifecycleExampleActivity() {
        val intent = Intent(this, LifecycleExampleActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToLaunchModeActivity() {
        val intent = Intent(this, LaunchModeExampleActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSenderDataActivity() {
        val intent = Intent(this, SenderActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToRegisterForActivityResultActivity() {
        val intent = Intent(this, RegisterForActivityResultExampleActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSelectImageActivity() {
        val intent = Intent(this, SelectImageActivity::class.java)
        startActivity(intent)
    }
}