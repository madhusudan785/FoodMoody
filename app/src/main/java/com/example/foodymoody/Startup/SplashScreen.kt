package com.example.foodymoody.Startup

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.foodymoody.R


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splaash_screen)
        android.os
            .Handler(Looper.getMainLooper())
            .postDelayed({
                val intent = Intent(this, GetStarted::class.java)
                startActivity(intent)
                finish()
            },1000)

    }
}


