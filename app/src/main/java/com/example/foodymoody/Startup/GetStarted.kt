package com.example.foodymoody.Startup

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodymoody.Authentication.LoginActivity
import com.example.foodymoody.R
import com.example.foodymoody.databinding.ActivityGetStartedBinding

class GetStarted : AppCompatActivity() {
    private val binding:ActivityGetStartedBinding by lazy {
        ActivityGetStartedBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.nextButton.setOnClickListener {

            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)

        }



    }
}