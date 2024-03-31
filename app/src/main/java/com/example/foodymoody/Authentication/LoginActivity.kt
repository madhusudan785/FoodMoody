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
import com.example.foodymoody.databinding.ActivityGetStartedBinding
import com.example.foodymoody.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val underLinetext= findViewById<TextView>(R.id.dont_have_an_account)
        underLinetext
            .text = "Don’t Have Account?"
        underLinetext.paintFlags = underLinetext.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        binding.dontHaveAnAccount.setOnClickListener {
            val intent = Intent (this,Signup ::class.java )
            startActivity(intent)
        }

    }
}