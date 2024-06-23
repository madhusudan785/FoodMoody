package com.example.foodymoody.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.example.foodymoody.MainActivity
import com.example.foodymoody.R
import com.example.foodymoody.databinding.FragmentContragratsBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class CongratsBottomSheet : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentContragratsBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContragratsBottomSheetBinding.inflate(inflater, container, false)

        // Access the LottieAnimationView using the binding object
        val animationView = binding.congrats
        animationView.setAnimation(R.raw.congratulations)
        animationView.playAnimation()

        binding.goHome.setOnClickListener {
           val intent =Intent(requireContext(),MainActivity::class.java)
            startActivity(intent)
        }

        // Return the root view
        return binding.root
    }

    companion object {

            }

}