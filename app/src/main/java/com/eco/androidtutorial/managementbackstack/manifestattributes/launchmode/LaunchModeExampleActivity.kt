package com.eco.androidtutorial.managementbackstack.manifestattributes.launchmode

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.eco.androidtutorial.databinding.ActivityLaunchmodeExampleBinding

class LaunchModeExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLaunchmodeExampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLaunchmodeExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            btnNotificationDetailActivity.setOnClickListener {
                navigateToNotificationDetailActivity()
            }
        }
    }

    fun navigateToNotificationDetailActivity() {
        val intent = Intent(this, NotificationDetailActivity::class.java)
        startActivity(intent)
    }
}
