package com.eco.musicplayer.audioplayer.music.ui.yearlysubscriptionbottomsheet

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.eco.music.R
import com.eco.music.databinding.ActivityYearlySubscriptionBinding
import com.eco.musicplayer.audioplayer.music.ui.TermAndPrivacyHelper
import com.eco.musicplayer.audioplayer.music.ui.paywallonboaring.StateTrial
import com.eco.musicplayer.audioplayer.music.ui.paywallonboaring.SubscriptionPlan
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class YearlySubscriptionBottomSheetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityYearlySubscriptionBinding
    private var subscriptionPlan: SubscriptionPlan = SubscriptionPlan.Yearly

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
        binding.apply {
            bottomSheet.subscriptionPlan = SubscriptionPlan.Yearly
            bottomSheet.stateTrial = StateTrial.Loading
            val displayMetrics = resources.displayMetrics
            val height = displayMetrics.heightPixels
            val targetHeight = (height * 0.62).toInt()
            val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet.root)
            bottomSheetBehavior.peekHeight = targetHeight
            bottomSheet.btnClose.setOnClickListener {
                finish()
            }
            setupTermsAndPrivacyText()
            bottomSheet.txtSalePercent.setOnClickListener {
                updateState(SubscriptionPlan.Yearly)
            }
            bottomSheet.bgYearlySubscriptionBottom.setOnClickListener {
                updateState(SubscriptionPlan.Yearly)
            }

            bottomSheet.bgWeeklySubscriptionBottom.setOnClickListener {
                updateState(SubscriptionPlan.Weekly)
            }
        }
    }

    private fun setupTermsAndPrivacyText() {
        TermAndPrivacyHelper(
            this, binding.bottomSheet.txtTermsAndPolicies, R.color.color_4D5A68
        ).setup()
    }

    private fun updateState(newState: SubscriptionPlan) {
        if (newState == subscriptionPlan) return
        subscriptionPlan = newState
        when (newState) {
            SubscriptionPlan.Yearly -> binding.apply {
                bottomSheet.subscriptionPlan = SubscriptionPlan.Yearly
                bottomSheet.txtSalePercent.setBackgroundResource(R.drawable.bg_txt_yearly_subscription_top_selected)
                bottomSheet.bgYearlySubscriptionBottom.setBackgroundResource(R.drawable.bg_txt_yearly_subscription_bottom_selected)
                bottomSheet.bgWeeklySubscriptionBottom.setBackgroundResource(R.drawable.bg_txt_weekly_subscription_unselected)
            }

            SubscriptionPlan.Weekly -> binding.apply {
                bottomSheet.subscriptionPlan = SubscriptionPlan.Weekly
                bottomSheet.txtSalePercent.setBackgroundResource(R.drawable.bg_txt_yearly_subscription_top_unselected)
                bottomSheet.bgYearlySubscriptionBottom.setBackgroundResource(R.drawable.bg_txt_yearly_subscription_bottom_unselected)
                bottomSheet.bgWeeklySubscriptionBottom.setBackgroundResource(R.drawable.bg_txt_weekly_subscription_selected)
            }
        }
    }
}