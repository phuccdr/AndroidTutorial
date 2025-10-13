package com.eco.androidtutorial.lifecycle.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.eco.androidtutorial.databinding.ActivityDashboardBinding
import kotlinx.coroutines.launch

private const val TAG = "DashboardActivity"

/**
 * Trong ComponentActivity chứa ViewModelStoreOwner có:
 * private val map = mutableMapOf<String, ViewModel>() -> 1 activity có thể có nhiều viewModel nó được gắn với vòng đời để
 * trong ActivityComponent chứa logic để xu lý khi activity destroy thì các viewModel trong activity cũng bị destroy
 * ComponentActivity implement LifecycleOwner: có thuộc tính lifecycle:Lifecycle (abstract class chứa các trạng thái của activity, phương thức để theo dõi lifecycle
 * và có coroutineScope được gắn với lifecycle.)
 */
class DashboardActivity : AppCompatActivity() {
    private val viewModel: DashboardViewModel by viewModels()
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeData()
    }

    private fun observeData() {
        viewModel.fetchData()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.devices.collect { devices ->
                    binding.device = devices[0]
                }
            }
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

}