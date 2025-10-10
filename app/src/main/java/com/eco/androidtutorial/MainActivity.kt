package com.eco.androidtutorial

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.eco.androidtutorial.NavigateExampleActivity.Companion.EXTRA_KEY
import com.eco.androidtutorial.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate")
        Log.d(TAG, "Khoi tao cac thanh phan chinh, bind data vào list, gan layout")
        setupUI()
    }

    private fun setupUI() {
        viewModel.fetchData()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.devices.collect { devices ->
                    binding.device = devices[0]
                }
            }
        }
        binding.btnNav.setOnClickListener {
            navigateToNavigateExampleActivity(viewModel.devices.value[0].name)
        }
        binding.btnRegisterforactivityresult.setOnClickListener {
            navigateToRegisterForActivityResultExampleActivity()
        }
    }

    private fun navigateToRegisterForActivityResultExampleActivity() {
        binding.btnRegisterforactivityresult.setOnClickListener {
            val intent = Intent(this, RegisterForActivityResultExampleActivity::class.java)
            startActivity(intent)
        }
    }

    private fun navigateToNavigateExampleActivity(nameDevice: String?) {
        val intent = Intent(this, NavigateExampleActivity::class.java)
        nameDevice?.let {
            intent.putExtra(EXTRA_KEY, it)
        }
        startActivity(intent)
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