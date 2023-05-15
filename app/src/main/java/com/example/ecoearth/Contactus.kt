package com.example.ecoearth

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ecoearth.databinding.ContactUsBinding
import com.example.ecoearth.databinding.SettingActivityBinding

class Contactus : Fragment() {
    private lateinit var binding: ContactUsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): ConstraintLayout {
        binding = ContactUsBinding.inflate(inflater, container ,false)

        binding.formBtn.setOnClickListener{link()}

        return binding.root
    }

    private fun link(){

        val url = "https://forms.gle/3qs7FCRS9hgsYco4A"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }
}