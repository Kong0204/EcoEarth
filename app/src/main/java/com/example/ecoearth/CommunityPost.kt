package com.example.ecoearth

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.ecoearth.databinding.CommunityPostBinding
import java.util.*

class CommunityPost : Fragment() {
    private lateinit var binding: CommunityPostBinding
    private val auths : EventViewModel by activityViewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): ConstraintLayout {
        binding = CommunityPostBinding.inflate(inflater, container, false)

        binding.doneBtn.setOnClickListener{addevent()}

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addevent() {

        val eventname = binding.editEN.text.toString()
        val oName = binding.editEN2.text.toString()
        val eventDes = binding.editEN3.text.toString()
        val date = binding.editEN4.text.toString()
        val contactNo = binding.editEN5.text.toString()

        auths.addEvent(eventname, oName,eventDes,contactNo, date)

        findNavController().navigate(R.id.action_communityPost_to_community)

    }


}