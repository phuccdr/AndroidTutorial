package com.eco.androidtutorial.ui.paywallonboaring

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.eco.androidtutorial.R
import com.eco.androidtutorial.databinding.ActivityPaywallOnboardingBinding
import com.eco.androidtutorial.ui.TermAndPrivacyHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PaywallOnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaywallOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPaywallOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        loadData()
    }

    private fun setupUI() {
        binding.apply {
            subscriptionPlan = SubscriptionPlan.Yearly
            toggleState = true
            btnYearly.setOnClickListener {
                subscriptionPlan = SubscriptionPlan.Yearly
            }
            btnWeekly.setOnClickListener {
                subscriptionPlan = SubscriptionPlan.Weekly
            }
            switchTrial.setOnCheckedChangeListener { _, isChecked ->
                toggleState = isChecked
            }
            btnClose.setOnClickListener {
                finish()
            }
        }
        setupTermsAndPrivacyText()
    }

    private fun setupTermsAndPrivacyText() {
        TermAndPrivacyHelper(this, binding.txtTermsAndPolicies, R.color.color_4D5A68).setup()
        TermAndPrivacyHelper(
            this, binding.txtTermsAndPoliciesNotEligible, R.color.color_4D5A68
        ).setup()
    }

    private fun loadData() {
        updateTrialState(StateTrial.Loading)
        checkEligibleTrial()
    }

    private fun checkEligibleTrial() {
        updateTrialState(StateTrial.Loading)
        lifecycleScope.launch {
            delay(2000)
            val state = listOf(1, 2).random()
            when (state) {
                1 -> updateTrialState(StateTrial.Eligible)
                2 -> updateTrialState(StateTrial.NotEligible)
            }
        }
    }

    private fun updateTrialState(state: StateTrial) {
        binding.stateTrial = state
    }
}