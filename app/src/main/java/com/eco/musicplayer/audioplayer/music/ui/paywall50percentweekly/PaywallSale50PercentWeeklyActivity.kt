package com.eco.musicplayer.audioplayer.music.ui.paywall50percentweekly

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.eco.music.databinding.ActivityPaywallSale50percentWeeklyBinding
import com.eco.musicplayer.audioplayer.music.ui.LoadingState
import com.eco.musicplayer.audioplayer.music.ui.TermAndPrivacyHelper
import com.google.android.material.bottomsheet.BottomSheetBehavior
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
        loadData()
    }

    private fun setupUI() {
        setupTermsAndPrivacyText()
        setupClickListeners()
        setupBottomSheet()
    }

    private fun setupBottomSheet() {
        val displayMetrics = resources.displayMetrics
        val heightScreen = displayMetrics.heightPixels
        binding.lottieAnimation.post {
            val heightLottieAnimation = binding.lottieAnimation.height
            val bottomSheetHeight =
                heightScreen - heightLottieAnimation + (45 * displayMetrics.density).toInt()
            val bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheetPaywall.root)
            bottomSheetBehavior.peekHeight = bottomSheetHeight
        }
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