package com.genius.orla.UI.menu.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.genius.orla.UI.menu.MenuListFragment


class MenuCategoryTabAdapter(fm : FragmentManager, val fragmentCount : Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when(position){
            0 -> {
                var drinkListFragment : MenuListFragment = MenuListFragment.newInstance(0)
                return drinkListFragment
            }
            1 -> {
                var saladListFragment : MenuListFragment = MenuListFragment.newInstance(1)
                return saladListFragment
            }
            2 -> {
                var sandListFragment : MenuListFragment = MenuListFragment.newInstance(2)
                return sandListFragment
            }
            3 -> {
                var fruitListFragment : MenuListFragment = MenuListFragment.newInstance(3)
                return fruitListFragment
            }
            else -> return null
        }
    }

    override fun getCount(): Int = fragmentCount // 자바에서는 { return fragmentCount }

}
