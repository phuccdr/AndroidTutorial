package com.eco.musicplayer.audioplayer.music.ui.paywallonboaring

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.eco.music.R

@BindingAdapter("subscriptionPlan", "stateTrial", "stateToggle", requireAll = true)
fun TextView.setIntroductionWithPlanSubscription(
    subscriptionPlan: SubscriptionPlan, stateTrial: StateTrial, stateToggle: Boolean
) {
    if (stateTrial == StateTrial.Eligible && stateToggle) {
        if (subscriptionPlan == SubscriptionPlan.Weekly) {
            text = context.getString(R.string.introductionWeeklyEligible)
        } else if (subscriptionPlan == SubscriptionPlan.Yearly) {
            text = context.getString(R.string.introductionYearlyEligible)
        }
    } else if (stateTrial == StateTrial.NotEligible || !stateToggle) {
        if (subscriptionPlan == SubscriptionPlan.Weekly) {
            text = context.getString(R.string.introductionWeeklyNotEligible)
        } else if (subscriptionPlan == SubscriptionPlan.Yearly) {
            text = context.getString(R.string.introductionYearlyNotEligible)
        }
    } else if (stateTrial == StateTrial.Loading) {
        text = ""
    }
}

@BindingAdapter("stateTrial")
fun TextView.setStateTrialButtonTryForFree(stateTrial: StateTrial) {
    if (stateTrial == StateTrial.Loading) {
        text = ""
        this.setBackgroundResource(R.drawable.bg_button_try_for_free_loading)
    } else if (stateTrial == StateTrial.NotEligible) {
        this.visibility = View.INVISIBLE
    } else if (stateTrial == StateTrial.Eligible) {
        this.setBackgroundResource(R.drawable.bg_button_try_for_free)
        text = context.getString(R.string.try_for_free)
    }
}

@BindingAdapter("selectedSubscriptionPlan", "targetSubscriptionPlan", requireAll = true)
fun TextView.setSelectedSubscriptionPlan(plan: SubscriptionPlan?, targetPlan: SubscriptionPlan?) {
    isSelected = plan == targetPlan
    if (isSelected) {
        setTextColor(ContextCompat.getColor(context, R.color.color_0F1E47))
        setBackgroundResource(R.drawable.bg_switch_toggle_selected)
    } else {
        setTextColor(ContextCompat.getColor(context, R.color.color_EAF5F8))
        setBackgroundResource(R.drawable.bg_switch_toggle_unselected)
    }
}


