package com.example.ecoearth

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.ecoearth.databinding.EduVideoBinding

class Homepage : Fragment() {

    private lateinit var binding: EduVideoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): ConstraintLayout {
        binding = EduVideoBinding.inflate(inflater, container ,false)

        binding.v1.setOnClickListener{link1()}
        binding.v2.setOnClickListener{link2()}
        binding.v3.setOnClickListener{link3()}

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
}