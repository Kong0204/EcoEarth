package com.example.ecoearth

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Observable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.example.ecoearth.databinding.ActivitySignUppageBinding
import com.jakewharton.rxbinding2.widget.RxTextView

@SuppressLint("CheckResult")
class SignUppage : AppCompatActivity() {
    private lateinit var binding: ActivitySignUppageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUppageBinding.inflate (layoutInflater)
        setContentView(binding.root)

        //Fullname Validation
        val nameStream = RxTextView.textChanges (binding.Name)
            .skipInitialValue().map { name ->
                name.isEmpty()
            }
        nameStream.subscribe {
            showNameExistAlert(it)
        }
        //Email Validation
            val emailStream = RxTextView.textChanges(binding.resEmail)
            .skipInitialValue()
            .map { email ->
                !Patterns.EMAIL_ADDRESS.matcher (email).matches ()
            }
        emailStream.subscribe {
            showEmailValidAlert(it)
        }
        // Password Validation
            val passwordStream = RxTextView.textChanges (binding.resPassword)
                .skipInitialValue()
                .map { password ->
                password.length < 6
                }
            passwordStream.subscribe {
                    showTextMinimalAlert(it,"Password")
            }
        //Confirm Password Validation
            val passwordComfirmStream = io.reactivex.Observable.merge(
                RxTextView.textChanges(binding.resPassword)
                    .skipInitialValue()
                    .map { password ->
                        password.toString() != binding.checkPsswd.text.toString()
                    },
                RxTextView.textChanges(binding.checkPsswd)
                    .skipInitialValue()
                    .map { password ->
                        password.toString() != binding.resPassword.text.toString()
                    })
            passwordComfirmStream.subscribe {
                showPasswordConfirmAlert(it)
            }
        // Click
        binding.signupButton.setOnClickListener {
            startActivity (Intent( this, Loginpage::class.java))
        }
        binding.noAccount.setOnClickListener {
            startActivity (Intent( this, Loginpage::class.java))
        }
    }
        private fun showNameExistAlert(isNotValid: Boolean) {
            binding.Name.error = if (isNotValid) "Nama cannot be empty!" else null
        }

        private fun showTextMinimalAlert(isNotValid: Boolean, text: String) {
            if (text == "Password")
                binding.resPassword.error = if (isNotValid) "$text need to be more than 8 characters!" else null
        }
        private fun showEmailValidAlert (isNotValid: Boolean) {
            binding.resEmail.error = if (isNotValid) "Email not valid!" else null
        }
        private fun showPasswordConfirmAlert(isNotValid: Boolean) {
            binding.checkPsswd.error = if (isNotValid) "Password not same!" else null
        }
}