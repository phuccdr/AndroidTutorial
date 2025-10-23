package com.eco.androidtutorial.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.eco.androidtutorial.databinding.ActivityPaywallMainBinding
import com.eco.androidtutorial.ui.dialogweekly.DemoDialogSale30percentWeeklyActivity
import com.eco.androidtutorial.ui.dialogyearly.DemoDialogSale30percentYearlyActivity
import com.eco.androidtutorial.ui.paywall50percentweekly.PaywallSale50PercentWeeklyActivity
import com.eco.androidtutorial.ui.paywallonboaring.PaywallOnboardingActivity
import com.eco.androidtutorial.ui.unlock.UnlockActivity
import com.eco.androidtutorial.ui.yearlysubscriptionbottomsheet.YearlySubscriptionBottomSheetActivity

class PaywallMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaywallMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPaywallMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            btnNavigateToPaywallSale50PercentWeekly.setOnClickListener {
                navigateToPaywallSale50PercentWeeklyActivity()
            }
            btnNavigateToDialogSale30PercentWeekly.setOnClickListener {
                navigateToDialogSale30PercentWeeklyActivity()
            }
            btnNavigateToDialogSale30PercentYearly.setOnClickListener {
                navigateToDialogSale30PercentYearlyActivity()
            }
            btnNavigateToPaywallOnboarding.setOnClickListener {
                navigateToPaywallOnboardingActivity()
            }
            btnNavigateToUnLockFeature.setOnClickListener {
                navigateToUnlockFeatureActivity()
            }
            btnNavigateToYearlySubscriptionBottomSheet.setOnClickListener {
                navigateToYearlySubscriptionBottomSheetActivity()
            }
            btnNavigateToYearlySubscriptionFullScreen.setOnClickListener {
                navigateToYearlySubscriptionFullScreenActivity()
            }
        }
    }

    private fun navigateToPaywallSale50PercentWeeklyActivity() {
        val intent = Intent(this, PaywallSale50PercentWeeklyActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToDialogSale30PercentWeeklyActivity() {
        val intent = Intent(this, DemoDialogSale30percentWeeklyActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToDialogSale30PercentYearlyActivity() {
        val intent = Intent(this, DemoDialogSale30percentYearlyActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToPaywallOnboardingActivity() {
        val intent = Intent(this, PaywallOnboardingActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToUnlockFeatureActivity() {
        val intent = Intent(this, UnlockActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToYearlySubscriptionBottomSheetActivity() {
        val intent = Intent(this, YearlySubscriptionBottomSheetActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToYearlySubscriptionFullScreenActivity() {
        val intent = Intent(this, YearlySubscriptionFullScreenActivity::class.java)
        startActivity(intent)
    }
}