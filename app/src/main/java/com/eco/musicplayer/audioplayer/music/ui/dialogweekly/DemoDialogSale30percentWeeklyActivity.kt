package com.eco.musicplayer.audioplayer.music.ui.dialogweekly

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.eco.music.databinding.ActivityPerviewResultPaywallBinding

class DemoDialogSale30percentWeeklyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerviewResultPaywallBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPerviewResultPaywallBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        binding.btnShowDialogSale30PercentWeekly.setOnClickListener {
            val dialog = Sale30PercentWeeklyDialogFragment()
            dialog.show(supportFragmentManager, "SaleDialog30PercentWeekly")
        }
    }
}