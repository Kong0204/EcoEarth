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
import com.example.ecoearth.databinding.ActivityClimatetipsBinding
import com.example.ecoearth.databinding.SettingActivityBinding

class ClimateTips : Fragment() {
    private lateinit var binding: ActivityClimatetipsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): ConstraintLayout {
        binding = ActivityClimatetipsBinding.inflate(inflater, container ,false)

        binding.tipsVideoView1.setOnClickListener{tlink1()}
        binding.tipsVideoView2.setOnClickListener{tlink2()}

        return binding.root
    }

    private fun tlink1(){
        val url = "https://youtu.be/--tawdcPi4w"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun tlink2(){
        val url = "https://youtu.be/zzzMBQH3ZLY"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

}