package com.trinitydigital.viewpager.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trinitydigital.viewpager.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager()
    }

    private fun setupViewPager() {
        val adapter =
            ViewPagerAdapter(
                supportFragmentManager
            )
        viewPager.adapter = adapter
        adapter.addFragment(FirstFragment(), "Первый фрагмент")
        adapter.addFragment(SecondFragment(), "Второй фрагмент")
        adapter.addFragment(FirstFragment(), "Третий фрагмент")
        adapter.addFragment(FirstFragment(), "Первый фрагмент")
        adapter.addFragment(SecondFragment(), "Второй фрагмент")
        adapter.addFragment(FirstFragment(), "Третий фрагмент")
        tabLayout.setupWithViewPager(viewPager)
    }
}