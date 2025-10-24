package com.eco.musicplayer.audioplayer.music.ui.dialogyearly

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.eco.music.databinding.DialogSale30percentYearlyBinding
import com.eco.musicplayer.audioplayer.music.ui.LoadingState
import com.eco.musicplayer.audioplayer.music.ui.TermAndPrivacyHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Sale30PercentYearlyDialogFragment : DialogFragment() {
    private var _binding: DialogSale30percentYearlyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = DialogSale30percentYearlyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupTermsAndPrivacyText()
        loadData()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
        dialog?.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
        dialog?.window?.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        val params = dialog?.window?.attributes
        params?.dimAmount = 0.2f
        dialog?.window?.attributes = params
    }

    private fun setupListeners() {
        binding.txtTryAgain.setOnClickListener {
            loadData()
        }
        binding.btnClose.setOnClickListener {
            dismiss()
        }
    }

    private fun setupTermsAndPrivacyText() {
        TermAndPrivacyHelper(requireContext(), binding.tvTermsAndPrivacy).setup()
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
                    groupLoading.visibility = View.VISIBLE
                    groupSuccess.visibility = View.INVISIBLE
                    groupFailed.visibility = View.INVISIBLE
                }
            }

            LoadingState.Success -> {
                binding.apply {
                    groupSuccess.visibility = View.VISIBLE
                    groupLoading.visibility = View.INVISIBLE
                    groupFailed.visibility = View.INVISIBLE
                }
            }

            LoadingState.Failed -> {
                binding.apply {
                    groupFailed.visibility = View.VISIBLE
                    groupLoading.visibility = View.INVISIBLE
                    groupSuccess.visibility = View.INVISIBLE
                }
            }
        }
    }

}