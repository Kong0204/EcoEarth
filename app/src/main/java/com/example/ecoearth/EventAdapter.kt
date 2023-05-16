package com.example.ecoearth

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ecoearth.Event
import com.example.ecoearth.databinding.ShowEventDetailsBinding
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.time.Duration.Companion.days
var total = 50

class EventAdapter (
    val fn: (ViewHolder, Event) -> Unit = { _, _ -> }
) : ListAdapter<Event, EventAdapter.ViewHolder>(DiffCallback) {


    companion object DiffCallback : DiffUtil.ItemCallback<Event>() {
        override fun areItemsTheSame(a: Event, b: Event) = a.id == b.id
        override fun areContentsTheSame(a: Event, b: Event) = a == b
    }

    class ViewHolder(val binding: ShowEventDetailsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ShowEventDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val compoundlists = getItem(position)
//        @SuppressLint("SimpleDateFormat")
//        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
//        val date = compoundlists.date

//        val formattedDate = dateFormat.format(date)
        holder.binding.eventName.text = compoundlists.EventName
        holder.binding.content.text = compoundlists.Description
        holder.binding.showDate.text = compoundlists.Date
        holder.binding.orgName.text = compoundlists.OName
        holder.binding.contactNo.text = compoundlists.ContactNum

        fn(holder, compoundlists)
    }
}