package com.example.exem_proect5_kotlin.fragment

import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exem_proect5_kotlin.R
import com.example.exem_proect5_kotlin.adapter.AdapterChat
import com.example.exem_proect5_kotlin.adapter.AdapterChatTwo
import com.example.exem_proect5_kotlin.mpdel.Chat
import com.example.exem_proect5_kotlin.mpdel.Room

class PageOneFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var recycler_two: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view : View = inflater.inflate(R.layout.item_home_fragment, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        recycler_two = view.findViewById(R.id.recycler_two)
        recyclerView.layoutManager = GridLayoutManager(context,1)
        recycler_two.layoutManager = GridLayoutManager(context,2)

        refreshAdapters(getAllChats())
        refreshAdaptersTwo(getAllChatsTwo())
    }

    private fun getAllChatsTwo(): ArrayList<Chat> {
        val stories: ArrayList<Room> = ArrayList()

        val chats: ArrayList<Chat> = ArrayList()
        chats.add(Chat(stories))
        chats.add(Chat(Message(R.drawable.img2,"Murodjon",false,0)))
        chats.add(Chat(Message(R.drawable.img3,"Maqsit",true,0)))
        chats.add(Chat(Message(R.drawable.img14,"Jamol",false,0)))
        chats.add(Chat(Message(R.drawable.img15,"Karim",true,0)))
        chats.add(Chat(Message(R.drawable.img16,"Leyla",false,0)))
        chats.add(Chat(Message(R.drawable.img17,"Amanda",true,0)))
        chats.add(Chat(Message(R.drawable.img18,"Alex",false,0)))
        chats.add(Chat(Message(R.drawable.img19,"Bahodir",true,0)))
        chats.add(Chat(Message(R.drawable.img5,"Olim",false,0)))
        chats.add(Chat(Message(R.drawable.img6,"Zayniddin",true,0)))
        chats.add(Chat(Message(R.drawable.img7,"Javohir",false,0)))
        chats.add(Chat(Message(R.drawable.img8,"Umit",true,0)))
        chats.add(Chat(Message(R.drawable.img9,"Zaynab",false,0)))
        chats.add(Chat(Message(R.drawable.img10,"Sherali",false,0)))
        return chats
    }

    private fun refreshAdaptersTwo(allChatsTwo: ArrayList<Chat>) {
        val adapter = context?.let { AdapterChatTwo(it, allChatsTwo) }
        recycler_two.adapter = adapter
    }

    private fun refreshAdapters(chats:ArrayList<Chat>) {
        val adapter = context?.let { AdapterChat(it, chats) }
        recyclerView.adapter = adapter
    }

    private fun getAllChats(): ArrayList<Chat> {
        val stories: ArrayList<Room> = ArrayList()
        stories.add(Room(R.drawable.arab1,"",0))
        stories.add(Room(R.drawable.arab1,"Laziz Ubaydullayev",1))
        stories.add(Room(R.drawable.arab1,"Amir Ubaydullayev",1))
        stories.add(Room(R.drawable.arab1,"Said Ubaydullayev",1))
        stories.add(Room(R.drawable.arab1,"Jamshid Ubaydullayev",1))
        stories.add(Room(R.drawable.arab1,"Begzod Ubaydullayev",1))
        stories.add(Room(R.drawable.arab1,"Abdulhay Ubaydullayev",1))
        stories.add(Room(R.drawable.arab1,"Abdulhay Ubaydullayev",1))
        stories.add(Room(R.drawable.arab1,"Abdulhay Ubaydullayev",1))
        stories.add(Room(R.drawable.arab1,"Abdulhay Ubaydullayev",1))
        stories.add(Room(R.drawable.arab1,"Abdulhay Ubaydullayev",1))

        val chats: ArrayList<Chat> = ArrayList()
        chats.add(Chat(stories))
        return chats
    }
}