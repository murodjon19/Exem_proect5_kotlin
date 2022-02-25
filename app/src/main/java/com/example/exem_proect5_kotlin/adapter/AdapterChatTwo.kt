package com.example.exem_proect5_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exem_proect5_kotlin.R
import com.example.exem_proect5_kotlin.mpdel.Chat
import com.example.exem_proect5_kotlin.mpdel.Room
import com.google.android.material.imageview.ShapeableImageView


class AdapterChatTwo(var context: Context, var items:ArrayList<Chat>) :
RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_chat_message_two, parent, false)
        return MessageViewHolder4(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = items[position]


        if (holder is MessageViewHolder4) {
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun refreshAdapter(rooms: ArrayList<Room>, recyclerView: RecyclerView) {
        val adapter = RoomAdapter(context, rooms)
        recyclerView!!.adapter = adapter
    }
}

class MessageViewHolder4(var view: View) : RecyclerView.ViewHolder(view) {
    var iv_profile : ShapeableImageView
    var tv_fullname: TextView

    init {
        iv_profile = view.findViewById(R.id.iv_profile4)
        tv_fullname = view.findViewById(R.id.tv_fullname4)
    }
} {
}