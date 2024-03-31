package com.example.foodymoody.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.foodymoody.Adapter.PopularItemAdapter
import com.example.foodymoody.R

import com.example.foodymoody.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        binding.viewMenu.setOnClickListener {
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }
        return binding.root




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.bannernew3,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.bannernew4,ScaleTypes.FIT))


        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList,ScaleTypes.FIT)

        imageSlider.setItemClickListener(object : ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val message = "Selected Message $position"
                Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
            }
        })
        val foodName = listOf("Burger","Pizza","Dal Makhni","Garlic Bread")
        val price  = listOf("₹269","₹379","₹149","₹249")
        val images = listOf(R.drawable.burger,R.drawable.pizza,R.drawable.dalmakhni,R.drawable.garlicbread)
        val adapter = PopularItemAdapter(foodName,price,images)
        binding.popularRecylerView.layoutManager = LinearLayoutManager(requireContext())
        binding.popularRecylerView.adapter = adapter



    }
    companion object {

    }


}