package com.example.ecoearth
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*

data class Event(
    @DocumentId
    var id: String ="",
    var ContactNum: String ="",
    var Date: String = "",
    var Description: String ="",
    var EventName: String ="",
    var OName: String ="",

    )

val event = Firebase.firestore.collection("Event")