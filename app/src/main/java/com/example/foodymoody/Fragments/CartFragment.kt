package com.example.foodymoody.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodymoody.Adapter.CarItemAdapter
import com.example.foodymoody.R
import com.example.foodymoody.databinding.FragmentCartBinding
import java.util.ArrayList


class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)


        val cartItemName = listOf("Burger","Pizza","Garlic Bread","Dosa","Idli","Dal Makhni" )
        val cartItemPrice = listOf("₹159","₹269","₹150","₹50","₹35","₹150")
        val cartItemimage = listOf(R.drawable.burger,R.drawable.pizza,R.drawable.garlicbread,R.drawable.dosa,R.drawable.idli,R.drawable.dalmakhni)
        val adapter = CarItemAdapter(ArrayList(cartItemName),ArrayList(cartItemPrice),ArrayList(cartItemimage))

        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter

        return binding.root



    }

    companion object {

    }
}