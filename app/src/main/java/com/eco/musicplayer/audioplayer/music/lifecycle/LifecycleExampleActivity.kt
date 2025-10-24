package com.eco.musicplayer.audioplayer.music.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.eco.music.databinding.ActivityLifecycleExampleBinding

class LifecycleExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLifecycleExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLifecycleExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate")
        Log.d(TAG, "Khoi tao cac thanh phan chinh, bind data vào list, gan layout")
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        Log.d(TAG, "Activity trở nên có thể nhìn thấy được")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        Log.d(TAG, "Activiy trở nên tương tác được")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        Log.d(TAG, "Activity bị mất focus")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        Log.d(TAG, "Activity không còn có thể nhìn thấy được")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        Log.d(TAG, "Activity bị hủy")
        super.onDestroy()
    }
}