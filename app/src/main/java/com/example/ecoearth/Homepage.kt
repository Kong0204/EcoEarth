package com.example.ecoearth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ecoearth.databinding.HomepageBinding

class Homepage : AppCompatActivity() {

    private lateinit var binding: HomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newbutton.setOnClickListener {
            startActivity(Intent(this, Newspage::class.java))
        }

        binding.tipsbutton.setOnClickListener {
            startActivity(Intent(this, ClimateTips::class.java))
        }

        binding.videobutton.setOnClickListener {
            startActivity(Intent(this, EducationVideo::class.java))
        }
    }
}
