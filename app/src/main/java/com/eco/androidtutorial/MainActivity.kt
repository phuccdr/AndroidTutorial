package com.eco.androidtutorial

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d(TAG, "onCreate")
        Log.d(TAG, "Khoi tao cac thanh phan chinh, bind data vào list, gan layout")
        val button = findViewById<TextView>(R.id.btn_nav)
        button.setOnClickListener {
            val intent = Intent(this, SecondaryActivity::class.java)
            startActivity(intent)
        }
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

    override val lifecycle: Lifecycle
        get() = super.lifecycle
}