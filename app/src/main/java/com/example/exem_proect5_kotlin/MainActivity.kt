package com.example.exem_proect5_kotlin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.exem_proect5_kotlin.adapter.ItemAdapter
import com.example.exem_proect5_kotlin.mpdel.ModelItem

class MainActivity : AppCompatActivity() {
    var l1lists: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        l1lists = findViewById(R.id.l1lists)
        initRecyclerView(getData())

    }

    private fun initRecyclerView(list: ArrayList<ModelItem>) {
        val rv = getRecyclerView()
        val adapter = ItemAdapter(this, list)
        rv!!.adapter = adapter
        initBottomDotc(adapter.getItemCount(), rv)
    }

    private fun getRecyclerView(): RecyclerView {
        val rv = RecyclerView(this)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.HORIZONTAL
        rv.layoutManager = layoutManager
        l1lists!!.addView(rv)
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rv)
        return rv
    }

    private fun getData(): ArrayList<ModelItem> {
        val list: ArrayList<ModelItem> = ArrayList()
        list.add(ModelItem(R.drawable.ic_baseline_favorite_border_24,"deferferfewgrtgtrgtr"))
        list.add(ModelItem(R.drawable.ic_baseline_add_photo_alternate_24,"derfrtgtrgwqswdwe"))
        list.add(ModelItem(R.drawable.ic_baseline_notifications_24,"dewfgythtynymnjyjyu"))
        list.add(ModelItem(R.drawable.ic_baseline_chat_24,"asadrefrefrbhjnyu"))

        return list
    }

    private fun initBottomDotc(itemCount: Int, rv: RecyclerView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && itemCount > 0) {
            val l1 = getBottomDotsLayout(itemCount)
            rv.setOnScrollChangeListener { view, i, i1, i2, i3 ->
                val firstVisible =
                    (rv.layoutManager as LinearLayoutManager?)!!.findFirstVisibleItemPosition()
                val lastVisible =
                    (rv.layoutManager as LinearLayoutManager?)!!.findLastVisibleItemPosition()
                var total = 0
                for (j in firstVisible..lastVisible) {
                    total++
                }
                transitionDots(l1!!, lastVisible, total)
            }
        }
    }

    private fun transitionDots(l1: LinearLayout, lastVisibleIndex: Int, totalVisibleItems: Int) {
        var lastVisibleIndex = lastVisibleIndex
        for (i in 0 until l1.childCount) {
            if (l1.getChildAt(i) is TextView) {
                l1.getChildAt(i).setBackgroundResource(R.drawable.indicator1)
            }
        }
        for (j in 0 until totalVisibleItems) {
            if (lastVisibleIndex >= 0) {
                l1.getChildAt(lastVisibleIndex).setBackgroundResource(R.drawable.indicator0)
                lastVisibleIndex--
            }
        }
    }

    private fun getBottomDotsLayout(count: Int): LinearLayout? {
        val l1 = LinearLayout(this)
        l1.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        l1.orientation = LinearLayout.HORIZONTAL
        l1.gravity = Gravity.CENTER
        for (i in 0 until count) {
            val tv = TextView(this)
            val params = LinearLayout.LayoutParams(25, 25)
            params.setMargins(10, 10, 10, 10)
            tv.layoutParams = params
            tv.setBackgroundResource(R.drawable.indicator1)
            l1.addView(tv)
        }
        l1lists!!.addView(l1)
        return l1
    }
}