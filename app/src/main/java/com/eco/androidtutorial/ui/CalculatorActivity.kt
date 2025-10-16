package com.eco.androidtutorial.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.eco.androidtutorial.R
import com.eco.androidtutorial.databinding.ActivityCalculatorBinding
import com.eco.androidtutorial.ui.customview.ButtonConfig

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding
    private val buttonConfigListColumn1: List<ButtonConfig> by lazy {
        listOf(
            ButtonConfig(R.drawable.ic_e),
            ButtonConfig(R.drawable.ic_ac),
            ButtonConfig(R.drawable.ic_7),
            ButtonConfig(R.drawable.ic_4),
            ButtonConfig(R.drawable.ic_1)
        )
    }
    private val buttonConfigListColumn2: List<ButtonConfig> by lazy {
        listOf(
            ButtonConfig(R.drawable.ic_u),
            ButtonConfig(R.drawable.ic_x),
            ButtonConfig(R.drawable.ic_8),
            ButtonConfig(R.drawable.ic_5),
            ButtonConfig(R.drawable.ic_2)
        )
    }
    private val buttonConfigListColumn3: List<ButtonConfig> by lazy {
        listOf(
            ButtonConfig(R.drawable.ic_sin),
            ButtonConfig(R.drawable.ic_i, R.drawable.bg_button_operator),
            ButtonConfig(R.drawable.ic_9),
            ButtonConfig(R.drawable.ic_6),
            ButtonConfig(R.drawable.ic_3)
        )
    }
    private val buttonConfigListColumn4: List<ButtonConfig> by lazy {
        listOf(
            ButtonConfig(R.drawable.ic_deg),
            ButtonConfig(R.drawable.ic_mul, R.drawable.bg_button_operator),
            ButtonConfig(R.drawable.ic_sub, R.drawable.bg_button_operator),
            ButtonConfig(R.drawable.ic_add, R.drawable.bg_button_operator),
            ButtonConfig(R.drawable.ic_equal, R.drawable.bg_button_equal)
        )
    }
    private val buttonConfigListRow1: List<ButtonConfig> by lazy {
        listOf(
            ButtonConfig(R.drawable.ic_zero), ButtonConfig(R.drawable.ic_dot)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            column1.buttons = buttonConfigListColumn1
            column2.buttons = buttonConfigListColumn2
            column3.buttons = buttonConfigListColumn3
            column4.buttons = buttonConfigListColumn4
            row1.buttons = buttonConfigListRow1
        }
    }
}