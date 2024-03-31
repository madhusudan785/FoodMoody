package com.example.foodymoody.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodymoody.databinding.CartItemListBinding

class CarItemAdapter(private val CartItem : MutableList<String>,private val CartItemPrice :MutableList<String> , private val CartImage : MutableList<Int>) : RecyclerView.Adapter<CarItemAdapter.CartViewHolder>() {

val itemQuantity = IntArray(CartItem.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarItemAdapter.CartViewHolder {
        val binding = CartItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int = CartItem.size


    override fun onBindViewHolder(holder: CarItemAdapter.CartViewHolder, position: Int) {
       holder.bind(position)
    }
   inner class CartViewHolder(private val binding: CartItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {

            binding.apply {
                val quantity = itemQuantity[position]
                foodName.text = CartItem[position]
                foodPrice.text=CartItemPrice[position]
                foodImg.setImageResource(CartImage[position])
                itemCount.text=quantity.toString()


                minusBtn.setOnClickListener {
                    decreaseQuantity(position)
                }
                plusBtn.setOnClickListener {
                    increaseQuantity(position)
                }
                deleteBtn.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION)
                        deleteItem(itemPosition)
                }
            }
        }
       private fun decreaseQuantity(position: Int){
           if (itemQuantity[position]>1){
               itemQuantity[position]--
               binding.itemCount.text=itemQuantity[position].toString()
           }
       }
       private fun increaseQuantity(position: Int){
           if (itemQuantity[position]<10){
               itemQuantity[position]++
               binding.itemCount.text=itemQuantity[position].toString()
           }
       }
       private fun deleteItem(position: Int){
           CartItem.removeAt(position)
           CartItemPrice.removeAt(position)
           CartImage.removeAt(position)
           notifyItemRemoved(position)
           notifyItemRangeChanged(position,CartItem.size)
       }

    }

}