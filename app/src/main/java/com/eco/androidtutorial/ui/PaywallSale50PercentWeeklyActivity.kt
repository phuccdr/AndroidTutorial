package com.eco.androidtutorial.ui

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.eco.androidtutorial.databinding.ActivityPaywallSale50percentWeeklyBinding

class PaywallSale50PercentWeeklyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaywallSale50percentWeeklyBinding
    private val linkTerms by lazy { "https://www.youtube.com/" }
    private val linkPrivacy by lazy { "privacypolicies.com" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPaywallSale50percentWeeklyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        setupTermsAndPrivacyText()
    }

    private fun setupTermsAndPrivacyText() {
        val fullText = binding.bottomSheetPaywall.tvTermsAndPrivacy.text.toString()
        val spannableString = SpannableString(fullText)
        val termsStart = fullText.indexOf("Terms")
        val termsEnd = termsStart + "Terms".length
        val privacyStart = fullText.indexOf("Privacy policies")
        val privacyEnd = privacyStart + "Privacy policies".length

        if (termsStart >= 0) {
            val termsClickableSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    openUrl(linkTerms)
                }

                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                    ds.isUnderlineText = true
                    ds.color = resources.getColor(android.R.color.white, null)
                }
            }

            spannableString.setSpan(
                termsClickableSpan, termsStart, termsEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            spannableString.setSpan(
                StyleSpan(Typeface.BOLD), termsStart, termsEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            spannableString.setSpan(
                UnderlineSpan(), termsStart, termsEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        if (privacyStart >= 0) {
            val privacyClickableSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    openUrl(linkPrivacy)
                }

                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                    ds.isUnderlineText = true
                    ds.color = resources.getColor(android.R.color.white, null)
                }
            }

            spannableString.setSpan(
                privacyClickableSpan, privacyStart, privacyEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            spannableString.setSpan(
                StyleSpan(Typeface.BOLD), privacyStart, privacyEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            spannableString.setSpan(
                UnderlineSpan(), privacyStart, privacyEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        binding.bottomSheetPaywall.tvTermsAndPrivacy.text = spannableString
        binding.bottomSheetPaywall.tvTermsAndPrivacy.movementMethod =
            LinkMovementMethod.getInstance()
    }

    private fun openUrl(url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, url.toUri())
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}