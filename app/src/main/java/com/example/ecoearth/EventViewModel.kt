package com.example.ecoearth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

//import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch


class EventViewModel : ViewModel(){

    private val eventLiveData = MutableLiveData<List<Event>>()
    private var listener: ListenerRegistration? = null
    private var eventlist = listOf<Event>()
    private var name = ""
    private var reverse = false

    var adminid = ""
    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCleared() {
        super.onCleared()
        listener?.remove()

    }

    // Return observable live data
    fun getEventLiveData() = eventLiveData


    fun addEvent(eventName: String, oname:String, desc: String, contact:String, eDate: String):Boolean {



        val l = Event(
            id = "",
            ContactNum = contact,
            Date = eDate,
        Description = desc,
        EventName = eventName,
        OName = oname,
        )

        Firebase.firestore
            .collection("Event")
            .document()
            .set(l)


        return true
    }

    init {
        viewModelScope.launch {
            event.addSnapshotListener { value, _ ->
                if (value == null) return@addSnapshotListener
                eventlist = value.toObjects<Event>()

                updateResult()
            }
        }
    }

    private fun updateResult() {
        var list = eventlist

        list = list.filter {
            it.EventName.contains(name, true)
        }
        if (reverse) list = list.reversed()

        eventLiveData.value = list
    }
}