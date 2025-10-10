package com.eco.androidtutorial

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.eco.androidtutorial.databinding.ActivityRegisterForResultExampleBinding


class RegisterForActivityResultExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterForResultExampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterForResultExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        binding.btnImportImage.setOnClickListener {
            pickImage()
        }
    }

    private fun pickImage() {
        registerForActivityResult(ActivityResultContracts.GetContent()){
                uri -> binding.tvUriImage.text = uri.toString()
        }
            .launch("image/*")
    }
}