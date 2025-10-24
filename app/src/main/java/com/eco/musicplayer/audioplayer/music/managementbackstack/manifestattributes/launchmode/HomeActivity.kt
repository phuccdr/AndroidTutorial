package com.eco.musicplayer.audioplayer.music.managementbackstack.manifestattributes.launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.eco.music.databinding.ActivityHomeBinding
import com.eco.musicplayer.audioplayer.music.utils.logTasksAndBackstack

class HomeActivity : AppCompatActivity() {
    /**
     * Single Task: chỉ 1 instance tồn tại trong hệ thống, Nếu activity đã tồn tại trong task đưa ra foreground và gọi onNewIntent và xóa các activity còn lại
     * Usecase: HomeActivity, LoginActivity
     */
    private val TAG = "Login"
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate running")
        logTasksAndBackstack(this)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d(TAG, "onNewIntent running")
    }
}