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
import com.example.ecoearth.databinding.EduVideoBinding
import com.example.ecoearth.databinding.SettingActivityBinding

class EducationVideo : Fragment() {
    private lateinit var binding: EduVideoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): ConstraintLayout {
        binding = EduVideoBinding.inflate(inflater, container ,false)

        binding.v1.setOnClickListener{link1()}
        binding.v2.setOnClickListener{link2()}
        binding.v3.setOnClickListener{link3()}
        binding.v4.setOnClickListener{link4()}
        binding.v5.setOnClickListener{link5()}
        binding.v6.setOnClickListener{link6()}
        binding.v7.setOnClickListener{link7()}
        binding.v8.setOnClickListener{link8()}
        binding.v9.setOnClickListener{link9()}
        binding.v10.setOnClickListener{link10()}

        return binding.root
    }

    private fun link1(){
        val url = "https://www.youtube.com/watch?v=EtW2rrLHs08"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun link2(){
        val url = "https://www.youtube.com/watch?v=OWXoRSIxyIU&t=1s"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun link3(){
        val url = "https://www.youtube.com/watch?v=ffjIyms1BX4"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun link4(){
        val url = "https://www.youtube.com/watch?v=dcBXmj1nMTQ"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun link5(){
        val url = "https://www.youtube.com/watch?v=uynhvHZUOOo"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun link6(){
        val url = "https://www.youtube.com/watch?v=G4H1N_yXBiA"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun link7(){
        val url = "https://www.youtube.com/watch?v=Uo82JwBSWbU"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun link8(){
        val url = "https://www.youtube.com/watch?v=2oxNId-H8r4"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun link9(){
        val url = "https://www.youtube.com/watch?v=IjT7O3ZodTA"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun link10(){
        val url = "https://www.youtube.com/watch?v=D4vjGSiRGKY"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }
}