package com.eco.musicplayer.audioplayer.music.ui.yearlysubscriptionfullscreen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.eco.music.R
import com.eco.music.databinding.ActivityYearlySubscriptionFullScreenBinding
import com.eco.musicplayer.audioplayer.music.ui.TermAndPrivacyHelper
import com.eco.musicplayer.audioplayer.music.ui.paywallonboaring.StateTrial
import com.eco.musicplayer.audioplayer.music.ui.paywallonboaring.SubscriptionPlan
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class YearlySubscriptionFullScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityYearlySubscriptionFullScreenBinding
    private var subscriptionPlan: SubscriptionPlan = SubscriptionPlan.Yearly
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityYearlySubscriptionFullScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupUI()
        loadData()
    }

    private fun setupUI() {
        setupBottomSheet()
        setupTermsAndPrivacyText()
        binding.apply {
            bottomSheet.subscriptionPlan = SubscriptionPlan.Yearly
            bottomSheet.stateTrial = StateTrial.Loading
            bottomSheet.txtSalePercent.setOnClickListener {
                updateState(SubscriptionPlan.Yearly)
            }
            bottomSheet.bgYearlySubscriptionBottom.setOnClickListener {
                updateState(SubscriptionPlan.Yearly)
            }

            bottomSheet.bgWeeklySubscriptionBottom.setOnClickListener {
                updateState(SubscriptionPlan.Weekly)
            }
            btnClose.setOnClickListener {
                finish()
            }
        }
    }

    private fun setupTermsAndPrivacyText() {
        TermAndPrivacyHelper(
            this, binding.bottomSheet.txtTermsAndPolicies, R.color.color_4D5A68
        ).setup()
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

    private fun setupBottomSheet() {
        val displayMetrics = resources.displayMetrics
        val heightScreen = displayMetrics.heightPixels
        binding.imageViewBanner.post {
            val heightImageHelloBanner = binding.imageViewBanner.height
            val bottomSheetHeight =
                heightScreen - heightImageHelloBanner + (24 * displayMetrics.density).toInt()
            val bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet.root)
            bottomSheetBehavior.peekHeight = bottomSheetHeight
        }
    }

    private fun updateStateTrial(state: StateTrial) {
        binding.bottomSheet.stateTrial = state
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