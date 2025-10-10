package com.eco.androidtutorial

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.eco.androidtutorial.databinding.ActivityNavigateExampleBinding

private const val TAG = "NavigateExampleActivity"

/**
 * demo vòng đời của activity khi navigate từ 1 activity sang 1 activity khác
 * demo onSaveInstanceState và onRestoreInstanceState lưu dữ liệu tạm thời khi xoay màn hình.
 */
class NavigateExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavigateExampleBinding
    private lateinit var deviceNameText: String
    private var gameStateText: String? = "Running"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNavigateExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate")
        setupUI(savedInstanceState)
    }

    private fun setupUI(savedInstanceState: Bundle?) {
        if(savedInstanceState != null){
            with(savedInstanceState){
                gameStateText = getString("GAME_STATE_KEY")
                deviceNameText = getString("KEY") ?: ""
            }
        }else{
            deviceNameText = intent.getStringExtra("KEY") ?: ""
        }
        binding.apply {
            deviceName.text = deviceNameText
            gameState.text = gameStateText
        }

        binding.button.setOnClickListener {
            gameStateText = "Stop"
            binding.gameState.text = gameStateText
        }
    }

    /**
     * ham onRestoreInstanceState được gọi sau onStart nếu trong onCreate không xử lý saveInstanceState
     */
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        Log.d(TAG, "onRestoreInstanceState lay du lieu duoc luu")
//        gameStateText = savedInstanceState.getString("GAME_STATE_KEY")
//        deviceNameText = savedInstanceState.getString("KEY") ?: ""
//        binding.apply {
//            gameState.text = gameStateText
//            deviceName.text = deviceNameText
//        }
//    }

    /**
     * ham onSaveInstanceState được gọi
     */
    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString(GAME_STATE_KEY, gameStateText)
            putString(EXTRA_KEY, deviceNameText)
        }
        Log.d(TAG, "onSaveInstanceState lưu dữ liệu tạm thời.")
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }
    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    companion object {
        const val EXTRA_KEY = "KEY"
        const val GAME_STATE_KEY = "GAME_STATE_KEY"
    }
}