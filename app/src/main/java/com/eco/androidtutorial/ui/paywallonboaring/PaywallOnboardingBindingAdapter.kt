package com.eco.androidtutorial.ui.paywallonboaring

import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.eco.androidtutorial.R

@BindingAdapter("subscriptionPlan", "stateTrial", requireAll = true)
fun TextView.setIntroductionWithPlanSubscription(
    subscriptionPlan: SubscriptionPlan, stateTrial: StateTrial
) {
    if (stateTrial == StateTrial.Eligible) {
        if (subscriptionPlan == SubscriptionPlan.Weekly) {
            text = context.getString(R.string.introductionWeeklyEligible)
        } else if (subscriptionPlan == SubscriptionPlan.Yearly) {
            text = context.getString(R.string.introductionYearlyEligible)
        }
    } else if (stateTrial == StateTrial.NotEligible) {
        if (subscriptionPlan == SubscriptionPlan.Weekly) {
            text = context.getString(R.string.introductionWeeklyNotEligible)
        } else if (subscriptionPlan == SubscriptionPlan.Yearly) {
            text = context.getString(R.string.introductionYearlyNotEligible)
        }
    }
}

@BindingAdapter("stateTrial")
fun TextView.setStateTrialButtonTryForFree(stateTrial: StateTrial) {
    if (stateTrial == StateTrial.Loading) {
        text = ""
        this.setBackgroundResource(R.color.color_5F5F5F)
    } else if (stateTrial == StateTrial.NotEligible) {
        this.setBackgroundResource(R.color.color_0F1E47)
        text = context.getString(R.string.continue1)
    } else if (stateTrial == StateTrial.Eligible) {
        this.setBackgroundResource(R.color.color_0F1E47)
        text = context.getString(R.string.try_for_free)
    }
}

@BindingAdapter("selectedSubscriptionPlan", "targetSubscriptionPlan", requireAll = true)
fun TextView.setSelectedIfYearly(plan: SubscriptionPlan?, targetPlan: SubscriptionPlan?) {
    isSelected = plan == targetPlan
    if (isSelected) {
        setTextColor(ContextCompat.getColor(context, R.color.color_0F1E47))
    } else {
        setTextColor(ContextCompat.getColor(context, R.color.color_EAF5F8))
    }
}


