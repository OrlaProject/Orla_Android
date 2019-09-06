package com.genius.orla.UI.store.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.genius.orla.UI.store.fragment.SearchStoreFragment


class SearchStoreAdapter(fm : FragmentManager, val fragmentCount : Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when(position){
            0 -> return SearchStoreFragment()
            1 -> return SearchStoreFragment()
            else -> return null
        }
    }

    override fun getCount(): Int = fragmentCount

}
