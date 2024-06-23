package com.example.foodymoody.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodymoody.Adapter.MenuAdapter
import com.example.foodymoody.R
import com.example.foodymoody.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding:FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)
        binding.backArw.setOnClickListener {
            dismiss()
        }
        val menuItemName = listOf("Burger","Pizza","Garlic Bread","Dosa","Idli","Dal Makhni","Burger","Pizza","Garlic Bread","Dosa","Idli","Dal Makhni")
        val menuItemPrice = listOf("₹159","₹269","₹150","₹50","₹35","₹150","₹159","₹269","₹150","₹50","₹35","₹150")
        val menuItemImage = listOf(
            R.drawable.burger,
            R.drawable.pizza,
            R.drawable.garlicbread,
            R.drawable.dosa,
            R.drawable.idli,
            R.drawable.dalmakhni, R.drawable.burger,
            R.drawable.pizza,
            R.drawable.garlicbread,
            R.drawable.dosa,
            R.drawable.idli,
            R.drawable.dalmakhni)
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = MenuAdapter(
            ArrayList(menuItemName),
            ArrayList(menuItemPrice),
            ArrayList(menuItemImage),
            requireContext()
        )
        binding.menuRecyclerView.adapter = adapter

        return binding.root
    }

    companion object {
    }
}