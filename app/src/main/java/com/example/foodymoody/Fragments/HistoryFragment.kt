package com.example.foodymoody.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodymoody.Adapter.BuyAgainAdapter

import com.example.foodymoody.R
import com.example.foodymoody.databinding.BuyAgainItemBinding
import com.example.foodymoody.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        setUpRecylerView()
        return binding.root
    }
    private fun setUpRecylerView(){
        val buyAgainFoodName = arrayListOf("Food1","Food2","Food3","Food4","Food5","Food6")
        val buyAgainFoodPrice = arrayListOf("₹159","₹269","₹150","₹50","₹35","₹150")
        val buyAgainFoodImg= arrayListOf(R.drawable.burger,
            R.drawable.pizza,
            R.drawable.garlicbread,
            R.drawable.dosa,
            R.drawable.idli,
            R.drawable.dalmakhni)
        buyAgainAdapter = BuyAgainAdapter(
            buyAgainFoodName,
            buyAgainFoodPrice,
            buyAgainFoodImg
        )
        binding.buyAgainRcView.adapter=buyAgainAdapter
        binding.buyAgainRcView.layoutManager=LinearLayoutManager(requireContext())
    }

}