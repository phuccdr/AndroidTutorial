package com.eco.androidtutorial.ui.yearlysubscriptionbottomsheet

import android.graphics.drawable.GradientDrawable
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.eco.androidtutorial.R
import com.eco.androidtutorial.ui.paywallonboaring.StateTrial
import com.eco.androidtutorial.ui.paywallonboaring.SubscriptionPlan

@BindingAdapter("stateTrial")
fun TextView.setStateTrialButtonTryForFree(stateTrial: StateTrial) {
    val background = background
    var color = context.getColor(R.color.color_0E111B)
    if (stateTrial == StateTrial.Eligible) {
        text = context.getString(R.string.try_for_free)
    } else if (stateTrial == StateTrial.NotEligible) {
        text = context.getString(R.string.continue1)
    } else {
        text = ""
    }
    if (stateTrial != StateTrial.Loading) {
        color = context.getColor(R.color.color_8147FF)
    } else {
        color = context.getColor(R.color.color_5F5F5F)
    }
    if (background is GradientDrawable) {
        val drawable = background.mutate() as GradientDrawable
        drawable.setColor(color)
        this.background = drawable
    }
}

@BindingAdapter("stateTrial2", "subscriptionPlan2", requireAll = true)
fun TextView.setStateInduction(stateTrial: StateTrial, subscriptionPlan: SubscriptionPlan) {
    if (stateTrial == StateTrial.Eligible) {
        if (subscriptionPlan == SubscriptionPlan.Weekly) {
            text = context.getString(R.string.introduceSaleWeeklyEligible)
        } else if (subscriptionPlan == SubscriptionPlan.Yearly) {
            text = context.getString(R.string.introduceSaleYearlyEligible)
        }
    } else if (stateTrial == StateTrial.NotEligible) {
        if (subscriptionPlan == SubscriptionPlan.Weekly) {
            text = context.getString(R.string.introduceSaleWeeklyNotEligible)
        } else if (subscriptionPlan == SubscriptionPlan.Yearly) {
            text = context.getString(R.string.introduceSaleYearlyNotEligible)
        }
    } else {
        text = ""
    }
}