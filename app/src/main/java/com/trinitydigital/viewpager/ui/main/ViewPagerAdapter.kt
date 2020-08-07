package com.trinitydigital.viewpager.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    private var list = arrayListOf<Fragment>()
    private var titles = arrayListOf<String>()

    fun addFragment(fragment: Fragment, title: String) {
        list.add(fragment)
        titles.add(title)
        notifyDataSetChanged()
    }

    override fun getPageTitle(position: Int) = titles[position]
    override fun getItem(position: Int) = list[position]
    override fun getCount() = list.size
}