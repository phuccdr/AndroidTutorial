package com.eco.androidtutorial.ui.paywall50percentweekly

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.eco.androidtutorial.databinding.ActivityPaywallSale50percentWeeklyBinding
import com.eco.androidtutorial.ui.LoadingState
import com.eco.androidtutorial.ui.TermAndPrivacyHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PaywallSale50PercentWeeklyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaywallSale50percentWeeklyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPaywallSale50percentWeeklyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        setupTermsAndPrivacyText()
        setupClickListeners()
        loadData()
    }

    private fun setupClickListeners() {
        binding.bottomSheetPaywall.txtTryAgain.setOnClickListener {
            loadData()
        }
        binding.btnClose.setOnClickListener {
            finish()
        }
    }

    private fun loadData() {
        updateUIState(LoadingState.Loading)

        lifecycleScope.launch {
            delay(2000)
            val state = listOf(1, 2).random()
            when (state) {
                1 -> updateUIState(LoadingState.Success)
                2 -> updateUIState(LoadingState.Failed)
            }
        }
    }

    private fun updateUIState(state: LoadingState) {
        when (state) {
            LoadingState.Loading -> {
                binding.apply {
                    bottomSheetPaywall.viewGroupLoading.visibility = View.VISIBLE
                    bottomSheetPaywall.viewGroupContent.visibility = View.INVISIBLE
                    bottomSheetPaywall.viewGroupFailed.visibility = View.INVISIBLE
                }
            }

            LoadingState.Success -> {
                binding.apply {
                    bottomSheetPaywall.viewGroupLoading.visibility = View.INVISIBLE
                    bottomSheetPaywall.viewGroupContent.visibility = View.VISIBLE
                    bottomSheetPaywall.viewGroupFailed.visibility = View.INVISIBLE
                }
            }

            LoadingState.Failed -> {
                binding.apply {
                    bottomSheetPaywall.viewGroupLoading.visibility = View.INVISIBLE
                    bottomSheetPaywall.viewGroupContent.visibility = View.INVISIBLE
                    bottomSheetPaywall.viewGroupFailed.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun setupTermsAndPrivacyText() {
        TermAndPrivacyHelper(this, binding.bottomSheetPaywall.tvTermsAndPrivacy).setup()
    }
}