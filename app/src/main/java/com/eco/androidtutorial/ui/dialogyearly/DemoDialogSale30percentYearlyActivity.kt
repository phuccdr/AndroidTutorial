package com.eco.androidtutorial.ui.dialogyearly

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.eco.androidtutorial.databinding.ActivityDemoDialogSale30PercentYearlyBinding

class DemoDialogSale30percentYearlyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDemoDialogSale30PercentYearlyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDemoDialogSale30PercentYearlyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        binding.btnShowDialog.setOnClickListener {
            val dialog = Sale30PercentYearlyDialogFragment()
            dialog.show(supportFragmentManager, "SaleDialog30PercentYearly")
        }
    }
}