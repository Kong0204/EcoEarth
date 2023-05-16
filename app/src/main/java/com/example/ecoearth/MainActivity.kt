package com.example.ecoearth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ecoearth.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity () {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                binding = ActivityMainBinding.inflate (layoutInflater)
                setContentView(binding.root)
                binding.login.setOnClickListener {
                    startActivity(Intent(this, Loginpage::class.java))
                }
                binding.signup.setOnClickListener {
                    startActivity (Intent(this, SignUppage::class.java))
                }
    }
}
