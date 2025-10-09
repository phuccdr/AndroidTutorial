package com.eco.androidtutorial

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent

private const val TAG = "SecondaryActivity"
private lateinit var cameraComponent: CameraComponent

class SecondaryActivity : AppCompatActivity() {
    lateinit var textView: TextView
    var gameState: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d(TAG, "onCreate")
        setContentView(R.layout.activity_secondary)
        gameState = savedInstanceState?.getString("GAME_STATE_KEY")
        textView = findViewById(R.id.textView)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cameraComponent = CameraComponent(this.lifecycle)
        lifecycle.addObserver(cameraComponent)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        textView.text = savedInstanceState.getString("TEXT_STATE_KEY")
        Log.d(TAG, "onRestoreInstanceState lay du lieu duoc luu")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString("GAME_STATE_KEY", gameState)
            putString("TEXT_STATE_KEY", textView.text.toString())
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


}