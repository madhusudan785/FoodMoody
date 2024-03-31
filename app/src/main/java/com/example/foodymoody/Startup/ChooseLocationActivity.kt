package com.example.foodymoody.Startup

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodymoody.R
import com.example.foodymoody.databinding.ActivityChooseLocationBinding

class ChooseLocationActivity : AppCompatActivity() {
    private val bindig: ActivityChooseLocationBinding by lazy {

        ActivityChooseLocationBinding.inflate(layoutInflater)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(bindig.root)

        val locations= arrayOf("None","Cuttack","Bhubaneswar","Jaipur","Kendrapada")
        val adapter =   ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,locations)
        val spinner = bindig.listItem
        spinner.adapter=adapter


    }
}