package com.eco.androidtutorial.registerforactivityresult.common

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eco.androidtutorial.R
import com.eco.androidtutorial.databinding.ActivityChooseFileBinding

class ChooseFileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChooseFileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityChooseFileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnChooseFile.setOnClickListener {
            val intent = Intent().apply {
                putExtra("result", "uriFile: 88888888")
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}