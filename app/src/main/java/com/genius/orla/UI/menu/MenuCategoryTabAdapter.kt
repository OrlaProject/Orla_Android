package com.genius.orla.UI.menu

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.genius.orla.UI.menu.MenuListFragment


class MenuCategoryTabAdapter(fm : FragmentManager, val fragmentCount : Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when(position){
            0 -> return MenuListFragment()
            1 -> return MenuListFragment()
            2 -> return MenuListFragment()
            3 -> return MenuListFragment()
            else -> return null
        }
    }

    override fun getCount(): Int = fragmentCount // 자바에서는 { return fragmentCount }

}
