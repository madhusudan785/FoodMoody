package com.example.foodymoody.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodymoody.PaymentDetails.DetailsActivity
import com.example.foodymoody.databinding.MenuItemBinding

class MenuAdapter(private val menuItemsName: List<String>, private val menuItemPrice: MutableList<String>, private val menuImage: MutableList<Int>, private val requireContext : Context): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>()
{

    private val itemClickListener:OnClickListener ?= null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)

    }

    override fun getItemCount(): Int =menuItemsName.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)

    }

    inner class MenuViewHolder(private val binding:MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position =adapterPosition
                if ( position != RecyclerView.NO_POSITION){
                    itemClickListener?.onItemClick(position)
                }
                val intent =Intent(requireContext, DetailsActivity::class.java)
                intent.putExtra("MenuItemName",menuItemsName.get(position))
                intent.putExtra("MenuItemImage",menuImage.get(position))
                requireContext.startActivity(intent)
            }
        }
        fun bind(position: Int) {
            binding.apply {
                binding.foodName.text=menuItemsName[position]
                binding.menuFoodPrice.text=menuItemPrice[position]
                menuFoodImg.setImageResource(menuImage[position])


            }

        }

    }
    interface OnClickListener {
        fun onItemClick(position: Int)

    }


}


