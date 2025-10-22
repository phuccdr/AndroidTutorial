package com.eco.androidtutorial.ui.paywallonboaring

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.eco.androidtutorial.databinding.ActivityPaywallOnboardingBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PaywallOnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaywallOnboardingBinding
    private var toggleState = false
    private val subscriptionPlan = SubscriptionPlan.Weekly

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
            btnYearly.setOnClickListener {
                subscriptionPlan = SubscriptionPlan.Yearly
            }
            btnWeekly.setOnClickListener {
                subscriptionPlan = SubscriptionPlan.Weekly
            }
            switchTrial.setOnCheckedChangeListener { _, isChecked ->
                updateSwitchState(isChecked)
            }
        }
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

    private fun updateSwitchState(isChecked: Boolean) {

    }


}