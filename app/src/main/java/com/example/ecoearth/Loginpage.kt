package com.example.ecoearth

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.ecoearth.databinding.ActivityLoginpageBinding
import com.jakewharton.rxbinding2.widget.RxTextView

@SuppressLint( "CheckResult")
class Loginpage : AppCompatActivity() {
    private lateinit var binding: ActivityLoginpageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginpageBinding.inflate (layoutInflater)
        setContentView(binding.root)
        // Email Validation
        val emailStream = RxTextView.textChanges(binding.resEmail)
            .skipInitialValue()
            .map { email ->
                email.isEmpty()
            }
        emailStream.subscribe {
            showTextMinimalAlert(it, "Email")
        }
        // Password Validation
            val passwordStream = RxTextView.textChanges (binding.resPassword)
                .skipInitialValue()
                .map { password ->
                    password.isEmpty()
                }
            passwordStream.subscribe {
                showTextMinimalAlert(it, "Password")
            }
        //click
        binding.loginButton.setOnClickListener {
            startActivity (Intent(this, Homepage::class.java))
        }
        binding.noAccount.setOnClickListener {
            startActivity (Intent (this, SignUppage::class.java))
        }
    }
    private fun showTextMinimalAlert(isNotValid: Boolean, text: String) {
        if (text == "Email")
            binding.resEmail.error = if (isNotValid) "$text cannot be empty!" else null
        else if (text == "Password")
            binding.resPassword.error = if (isNotValid) "$text cannot be empty!" else null
    }
}