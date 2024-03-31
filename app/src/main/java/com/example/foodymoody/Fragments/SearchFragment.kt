package com.example.foodymoody.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodymoody.Adapter.MenuAdapter

import com.example.foodymoody.R
import com.example.foodymoody.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
  private lateinit var binding : FragmentSearchBinding

  private lateinit var adapter : MenuAdapter

  private  val menuFoodItemName = listOf("Burger","Pizza","Garlic Bread","Dosa","Idli","Dal Makhni")
    private val menuFoodPrice = listOf("₹159","₹269","₹150","₹50","₹35","₹150")
    private val menuFoodItemImage = listOf(
        R.drawable.burger,
        R.drawable.pizza,
        R.drawable.garlicbread,
        R.drawable.dosa,
        R.drawable.idli,
        R.drawable.dalmakhni)

    private val filteredFoodName = mutableListOf<String>()
    private val filteredFoodPrice = mutableListOf<String>()
    private val filteredFoodImage = mutableListOf<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filteredFoodName,
            filteredFoodPrice, filteredFoodImage
        )
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        //implement search view
         setUpSearchView()
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filteredFoodName.clear()
        filteredFoodPrice.clear()
        filteredFoodImage.clear()

        filteredFoodName.addAll(menuFoodItemName)
        filteredFoodPrice.addAll(menuFoodPrice)
        filteredFoodImage.addAll(menuFoodItemImage)
    }


    private fun setUpSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItem(query)
                return true

            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItem(newText)
                return true
            }

            private fun filterMenuItem(query: String) {
                filteredFoodName.clear()
                filteredFoodPrice.clear()
                filteredFoodImage.clear()
                
                menuFoodItemName.forEachIndexed { index, foodName ->
                    if (foodName.contains(query ,ignoreCase = true))
                    {
                        filteredFoodName.add(foodName)
                        filteredFoodPrice.add(menuFoodPrice[index])
                        filteredFoodImage.add(menuFoodItemImage[index])
                    }
                }
                adapter.notifyDataSetChanged()
                
                
            }

        })
    }

}