package com.example.exem_proect5_kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exem_proect5_kotlin.R

class SearchFragment class PageFourFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View = inflater.inflate(R.layout.item_search_fragment, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {

    }
}
