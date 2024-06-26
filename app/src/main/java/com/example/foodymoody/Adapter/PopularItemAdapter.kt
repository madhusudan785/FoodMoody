package com.example.foodymoody.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodymoody.PaymentDetails.DetailsActivity
import com.example.foodymoody.databinding.PopularItemListBinding

class PopularItemAdapter(private val items : List<String>,private val price:List<String>,private val images:List<Int>,private val requireContext:Context) : RecyclerView.Adapter<PopularItemAdapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val price = price[position]
        val image = images[position]

        holder.bind(item,image,price)
        holder.itemView.setOnClickListener {
            val intent = Intent(requireContext, DetailsActivity::class.java)
            intent.putExtra("MenuItemName",item)
            intent.putExtra("MenuItemImage",image)
            requireContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
      return items.size
    }


    class PopularViewHolder(private val binding: PopularItemListBinding) :  RecyclerView.ViewHolder(binding.root){
        private val imageView = binding.foodImg
        fun bind(item: String, image: Int, price:String) {
            binding.foodName.text=item
            binding.foodPrice.text=price
            imageView.setImageResource(image)





        }

    }

}