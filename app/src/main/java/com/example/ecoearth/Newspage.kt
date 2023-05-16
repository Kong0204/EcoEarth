package com.example.ecoearth

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.ecoearth.databinding.EduVideoBinding

class Newspage : Fragment() {

    private lateinit var binding: EduVideoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): ConstraintLayout {
        binding = EduVideoBinding.inflate(inflater, container ,false)

        binding.v1.setOnClickListener{nlink1()}
        binding.v2.setOnClickListener{nlink2()}
        binding.v3.setOnClickListener{nlink3()}

        return binding.root
    }
    private fun nlink1(){
        val url = "https://climate.nasa.gov/news/3246/nasa-says-2022-fifth-warmest-year-on-record-warming-trend-continues/"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun nlink2(){
        val url = "https://www.nst.com.my/news/nation/2023/03/887295/most-malaysians-not-sure-what-they-can-do-tackle-climate-change-expert#:~:text=According%20to%20the%20World%20Bank,degrees%20Celsius%20by%20the%202090s."
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun nlink3(){
        val url = "https://www.bbc.com/news/science-environment-24021772"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }
}