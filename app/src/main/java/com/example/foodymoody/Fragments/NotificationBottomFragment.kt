package com.example.foodymoody.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodymoody.Adapter.NotificationAdapter
import com.example.foodymoody.R
import com.example.foodymoody.databinding.FragmentNotficationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NotificationBottomFragment : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentNotficationBottomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotficationBottomBinding.inflate(layoutInflater,container,false)
        val notification = listOf("Your order has been Canceled Successfully","Order has been taken by the driver","Congrats Your Order Placed")
        val notificationImages  = listOf(R.drawable.sademoji,R.drawable.icon__1_,R.drawable.illustration)
        val adapter = NotificationAdapter(ArrayList(notification),ArrayList(notificationImages))
        binding.notificationrv.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationrv.adapter = adapter
        return binding.root
    }

    companion object {

    }
}