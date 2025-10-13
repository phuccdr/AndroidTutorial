package com.eco.androidtutorial.managementbackstack.manifestattributes.launchmode

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.eco.androidtutorial.databinding.ActivityLaunchmodeExampleBinding
import com.eco.androidtutorial.utils.logTasksAndBackstack

class LaunchModeExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLaunchmodeExampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLaunchmodeExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        logTasksAndBackstack(this)
    }

    private fun setupUI() {
        binding.apply {
            btnDemoSingleTop.setOnClickListener {
                navigateToNotificationDetailActivity()
            }
            btnDemoSingleTask.setOnClickListener {
                navigateToHomeActivity()
            }
            btnDemoSingleInstance.setOnClickListener {
                navigateToAlarmRingActivity()
            }
        }
    }

    fun navigateToNotificationDetailActivity() {
        val intent = Intent(this, NotificationDetailActivity::class.java)
        startActivity(intent)
    }

    fun navigateToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    fun navigateToAlarmRingActivity() {
        val intent = Intent(this, AlarmRingActivity::class.java)
        startActivity(intent)
    }
}
