package com.example.foodymoody

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodymoody.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val foodName=intent.getStringExtra("MenuItemName")
        val foodimg=intent.getIntExtra("MenuItemImage",0)
        binding.detailsfoodNameTv.text=foodName
        binding.DetailsFoodImg.setImageResource(foodimg)
        binding.backButton.setOnClickListener {
            finish()
        }

        }
    }
