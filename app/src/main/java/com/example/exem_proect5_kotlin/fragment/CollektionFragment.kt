package com.example.exem_proect5_kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exem_proect5_kotlin.R
import com.example.exem_proect5_kotlin.adapter.PeopleAdapter
import com.example.exem_proect5_kotlin.mpdel.Chat
import com.example.exem_proect5_kotlin.mpdel.Message
import com.example.exem_proect5_kotlin.mpdel.Room

class PageTwoFragment : Fragment() {

    lateinit var recyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View = inflater.inflate(R.layout.item_collections_fragment, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView3)
        recyclerView.setLayoutManager(GridLayoutManager(context,1))

        refreshAdapters(getAllChats())
    }

    private fun refreshAdapters(chats:ArrayList<Chat>) {
        val adapter = context?.let { PeopleAdapter(it, chats) }
        recyclerView.adapter = adapter
    }

    private fun getAllChats(): ArrayList<Chat> {
        val stories: ArrayList<Room> = ArrayList<Room>()
        stories.add(Room(R.drawable.img10,"",0))


        val chats: ArrayList<Chat> = ArrayList()

        chats.add(Chat(stories))

        chats.add(Chat(Message(R.drawable.img11,"Murodjon",false,R.drawable.img10)))
        chats.add(Chat(Message(R.drawable.img12,"Maqsit",true,R.drawable.img22)))

        return chats
    }


}