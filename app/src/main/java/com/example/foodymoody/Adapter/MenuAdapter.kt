package com.example.foodymoody.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodymoody.databinding.MenuItemBinding

class MenuAdapter(private val menuItems: List<String>, private val menuItemPrice: MutableList<String>, private val menuImage: MutableList<Int>): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)

    }

    override fun getItemCount(): Int =menuItems.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)

    }

    inner class MenuViewHolder(private val binding:MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                binding.foodName.text=menuItems[position]
                binding.menuFoodPrice.text=menuItemPrice[position]
                menuFoodImg.setImageResource(menuImage[position])
            }

        }

    }


}