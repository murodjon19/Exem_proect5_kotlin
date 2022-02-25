package com.example.exem_proect5_kotlin.mpdel

import androidx.room.Room

class Chat {
    var message: Message? = null
    var message2: Message2? = null
    var rooms: ArrayList<Room> = ArrayList()
    var position : Int = 0

    constructor(position: Int) {
        this.position = position
    }

    constructor(message: Message) {
        this.message = message
    }

    constructor(message2: Message2) {
        this.message2 = message2
    }

    constructor(rooms:ArrayList<Room>) {
        this.rooms = rooms
    }
}