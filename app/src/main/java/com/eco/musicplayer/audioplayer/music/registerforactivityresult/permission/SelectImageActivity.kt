package com.eco.musicplayer.audioplayer.music.registerforactivityresult.permission

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.eco.music.databinding.ActivitySelectImageBinding
import com.eco.musicplayer.audioplayer.music.registerforactivityresult.permission.module.MultiPermission
import com.eco.musicplayer.audioplayer.music.registerforactivityresult.permission.module.ReadAnWriteStoragePermission

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
        }.onDeny { permissionsDenied ->
            showDialogPermission(permissionsDenied)
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

    private fun openGallery() {
        pickImageLauncher.launch("image/*")
    }

    private fun showDialogPermission(permissionsDenied: Array<String>) {
        AlertDialog.Builder(this)
            .setTitle("Vui cấp các quyền sau đây để sử dụng tính năng của ứng dụng")
            .setMessage("Ứng dụng cần các quyền sau: ${permissionsDenied.joinToString()}. Vui lòng cấp quyền trong Cài đặt.")
            .setPositiveButton("Cài đặt") { _, _ ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    data = Uri.fromParts("package", this@SelectImageActivity.packageName, null)
                }
                startActivity(intent)
            }.setNegativeButton("Hủy", null).setCancelable(true).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        permission.clear()
    }
}