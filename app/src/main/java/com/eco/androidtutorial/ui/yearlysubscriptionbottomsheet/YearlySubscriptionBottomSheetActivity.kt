package com.eco.androidtutorial.ui.yearlysubscriptionbottomsheet

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.eco.androidtutorial.databinding.ActivityYearlySubscriptionBinding
import com.eco.androidtutorial.ui.paywallonboaring.StateTrial
import com.eco.androidtutorial.ui.paywallonboaring.SubscriptionPlan
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class YearlySubscriptionBottomSheetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityYearlySubscriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityYearlySubscriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        loadData()
    }

    private fun loadData() {
        updateStateTrial(StateTrial.Loading)
        checkEligible()
    }

    private fun checkEligible() {
        updateStateTrial(StateTrial.Loading)
        lifecycleScope.launch {
            delay(2000)
            val choose = listOf(1, 2).random()
            when (choose) {
                1 -> updateStateTrial(StateTrial.Eligible)
                2 -> updateStateTrial(StateTrial.NotEligible)
            }
        }
    }

    private fun updateStateTrial(state: StateTrial) {
        binding.bottomSheet.stateTrial = state
    }

    private fun setupUI() {
        binding.bottomSheet.subscriptionPlan = SubscriptionPlan.Yearly
        binding.bottomSheet.btnClose.setOnClickListener {

        }
    }
}