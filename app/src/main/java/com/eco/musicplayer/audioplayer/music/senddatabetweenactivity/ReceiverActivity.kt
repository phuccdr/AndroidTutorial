package com.eco.musicplayer.audioplayer.music.senddatabetweenactivity

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.eco.music.databinding.ActivityReceiverBinding

class ReceiverActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReceiverBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityReceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        val text = intent.getStringExtra("SendDataFromIntent")
        setupUI(bundle, text)
    }

    @Suppress("DEPRECATION")
    private fun setupUI(bundle: Bundle?, text: String?) {
        binding.apply {
            binding.tvDataFromIntent.text = text ?: ""
            val device1: Device?
            val device2: Device?
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                device1 = bundle?.getParcelable("Device1", Device::class.java)
                device2 = bundle?.getParcelable("Device2", Device::class.java)
            } else {
                device1 = bundle?.getParcelable("Device1")
                device2 = bundle?.getParcelable("Device2")
            }
            binding.tvDataFromBundle.text = device1.toString().plus("\n").plus(device2.toString())
            binding.tvDataFromBundle.text = device1.toString().plus("\n").plus(device2.toString())
        }
    }
}