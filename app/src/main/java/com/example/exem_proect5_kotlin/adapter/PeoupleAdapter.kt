package com.example.exem_proect5_kotlin.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exem_proect5_kotlin.R
import com.google.android.material.imageview.ShapeableImageView

class PeopleAdapter(var context: Context, var items:ArrayList<Chat>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_ITEM_ROOM = 0
    private val TYPE_ITEM_MESSAGE = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_ROOM) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_fragment_second_layout, parent, false)
            return RoomViewholder3(context,view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_fragment_second_people, parent, false)
        return MessageViewHolder2(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = items[position]

        if (holder is RoomViewholder3) {
        }

        if (holder is MessageViewHolder2) {
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname
            var profile3 = holder.profile3
            profile3.setImageResource(message.message!!.image)
            iv_profile.setImageResource(message.message!!.profile)
            tv_fullname.text = message.message!!.fullname

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        var feed = items[position]
        if (feed.rooms.size > 0)
            return TYPE_ITEM_ROOM
        return TYPE_ITEM_MESSAGE
    }
}


class RoomViewholder3(context: Context, view: View) : RecyclerView.ViewHolder(view) {

}

class MessageViewHolder2(var view: View) : RecyclerView.ViewHolder(view) {
    var iv_profile : ShapeableImageView
    var tv_fullname: TextView
    var profile3: ImageView


    init {
        iv_profile = view.findViewById(R.id.iv_profile4)
        tv_fullname = view.findViewById(R.id.tv_fullname4)
        profile3 = view.findViewById(R.id.profile3)
    }
}