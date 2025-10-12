package com.eco.androidtutorial.registerforactivityresult.permission

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.eco.androidtutorial.databinding.ActivitySelectImageBinding
import com.eco.androidtutorial.registerforactivityresult.permission.module.MultiPermission

class SelectImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectImageBinding
    private lateinit var permission: MultiPermission
    private lateinit var pickImageLauncher: ActivityResultLauncher<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySelectImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeImagePicker()
        handlerPermission()
        setupUI()
    }

    private fun initializeImagePicker() {
        pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let { binding.ivImage.setImageURI(uri) }
        }
    }

    private fun handlerPermission() {
        permission = ReadAnWriteStoragePermission(this).onSuccess {
            openGallery()
        }.onDeny {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupUI() {
        binding.btnSelectImage.setOnClickListener {
            /**
             * check permission nếu chưa đủ thì request
             */
            if (!permission.isGranted()) {
                permission.request()
            } else {
                openGallery()
            }
        }
    }

    fun openGallery() {
        pickImageLauncher.launch("image/*")
    }

    override fun onDestroy() {
        super.onDestroy()
        permission.clear()
    }
}