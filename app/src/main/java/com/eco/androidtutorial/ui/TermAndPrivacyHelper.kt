package com.eco.androidtutorial.ui

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.net.toUri

class TermAndPrivacyHelper (
    private val context: Context,
    private val textView: TextView?,
) {
    private val termsUrl: String =
        "https://www.youtube.com/watch?v=-mkCzFPo08M&list=RDX-ZBSrwouRs&index=2"
    private val privacyUrl: String =
        "https://www.figma.com/design/AU7SKNni4j2Kq5HA3Gb7a3/v9Compress---Intern-dev?node-id=4022-489&t=WwXHxIGikSbrddwo-0"

    private val termsKeyword: String = "Terms"
    private val privacyKeyword: String = "Privacy policies"
    private val isUnderline: Boolean = true
    private val textColor: Int = android.R.color.white

    fun setup(){
        val fullText = textView?.text.toString()
        val spannableString = SpannableString(fullText)

            setupClickableSpan(
                spannableString = spannableString,
                fullText = fullText,
                keyword = termsKeyword,
                url = termsUrl
            )

            setupClickableSpan(
                spannableString = spannableString,
                fullText = fullText,
                keyword = privacyKeyword,
                url = privacyUrl
            )

        textView?.text = spannableString
        textView?.movementMethod = LinkMovementMethod.getInstance()

    }

     private fun setupClickableSpan(
        spannableString: SpannableString,
        fullText: String,
        keyword: String,
        url: String
    ) {
        val startIndex = fullText.indexOf(keyword)
        if (startIndex < 0) return

        val endIndex = startIndex + keyword.length

        // Create clickable span
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                    openUrl(url)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = isUnderline
                ds.color = ContextCompat.getColor(context, textColor)
            }

        }

        spannableString.setSpan(
            clickableSpan,
            startIndex,
            endIndex,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

            spannableString.setSpan(
                StyleSpan(Typeface.BOLD),
                startIndex,
                endIndex,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            spannableString.setSpan(
                UnderlineSpan(),
                startIndex,
                endIndex,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
    }

    private fun openUrl(url:String){
        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
        context.startActivity(intent)
    }


}