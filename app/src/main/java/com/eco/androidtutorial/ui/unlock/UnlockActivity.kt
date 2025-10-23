package com.eco.androidtutorial.ui.unlock

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.eco.androidtutorial.R
import com.eco.androidtutorial.databinding.ActivityUnlockBinding
import com.eco.androidtutorial.ui.TermAndPrivacyHelper
import com.eco.androidtutorial.ui.paywallonboaring.StateTrial
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UnlockActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUnlockBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUnlockBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        loadData()
    }

    private fun setupUI() {
        setupTermsAndPrivacyText()
    }

    private fun setupTermsAndPrivacyText() {
        TermAndPrivacyHelper(this, binding.txtTermsAndPrivacy, R.color.color_4D5A68).setup()
    }

    private fun loadData() {
        updateUIState(StateTrial.Loading)
        lifecycleScope.launch {
            delay(3000)
            val choose = listOf(1, 2).random()
            when (choose) {
                1 -> updateUIState(StateTrial.Eligible)
                2 -> updateUIState(StateTrial.NotEligible)
            }
        }
    }

    private fun updateUIState(state: StateTrial) {
        binding.stateTrial = state
    }

}