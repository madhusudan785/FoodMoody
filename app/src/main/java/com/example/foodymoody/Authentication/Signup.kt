package com.example.foodymoody.Authentication

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodymoody.R
import com.example.foodymoody.databinding.ActivitySignupBinding

class Signup : AppCompatActivity() {
    private val binding:ActivitySignupBinding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        val underLinetext= findViewById<TextView>(R.id.already_have_an_account)
        underLinetext
            .text = "Already Have an Account?"
        underLinetext.paintFlags = underLinetext.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        binding.alreadyHaveAnAccount.setOnClickListener {
            val intent = Intent(this , LoginActivity::class.java)

            startActivity(intent)
        }

    }
}