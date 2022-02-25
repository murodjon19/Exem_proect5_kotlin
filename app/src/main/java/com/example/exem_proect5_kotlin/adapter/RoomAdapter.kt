package com.example.exem_proect5_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exem_proect5_kotlin.R
import com.example.exem_proect5_kotlin.mpdel.Room

class RoomAdapter(var context: Context, var items:ArrayList<Room>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private val TYPE_ITEM_ROOM = 0
    private val TYPE_ITEM_MESSAGE = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_ROOM) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_creat_room,parent,false)
            return CreateRoomViewHolder(view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_room_view,parent,false)
        return RoomViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        var feed = items[position]
        if (feed.isAvailavle == 0) return TYPE_ITEM_ROOM
        return TYPE_ITEM_MESSAGE
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val room = items[position]

        if (holder is RoomViewHolder) {
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname
            iv_profile.setImageResource(room.profile)
            tv_fullname.text = room.fullname

        }
    }