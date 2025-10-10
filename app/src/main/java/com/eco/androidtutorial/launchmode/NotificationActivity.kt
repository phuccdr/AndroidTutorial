package com.eco.androidtutorial.launchmode

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.eco.androidtutorial.databinding.ActivitySecondaryBinding
import com.eco.androidtutorial.model.Notification

private val TAG = "NotificationActivity"
class NotificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNavThirdActivity.setOnClickListener {
//            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
        Log.d(TAG,"onNewIntent running")
    }

private fun handleIntent(intent: Intent) {
    val notification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        intent.getParcelableExtra("notification", Notification::class.java)
    } else {
        @Suppress("DEPRECATION")
        intent.getParcelableExtra<Notification>("notification")
    }


}

}