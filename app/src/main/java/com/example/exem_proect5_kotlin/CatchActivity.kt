package com.example.exem_proect5_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exem_proect5_kotlin.fragment.PageFourFragment
import com.example.exem_proect5_kotlin.fragment.PageOneFragment
import com.example.exem_proect5_kotlin.fragment.PageThreeFragment
import com.example.exem_proect5_kotlin.fragment.PageTwoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ChatActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    private var firstFragment = PageOneFragment()
    private var secondFragment = PageTwoFragment()
    private var threeFragment = PageThreeFragment()
    private var fourFragment = PageFourFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catch)

        initViews()
    }

    private fun initViews() {

        bottomNavigationView = findViewById(R.id.bottom)
        replaceFragment(item_home_Fragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home_item -> replaceFragment(firstFragment)
                R.id.setting_second -> replaceFragment(secondFragment)
                R.id.setting_three -> replaceFragment(threeFragment)
                R.id.setting_four -> replaceFragment(fourFragment)
            }
            true
        }

    }

    private fun replaceFragment(fragment: PageOneFragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.viewpager,fragment)
            transaction.commit()
        }
    }
}