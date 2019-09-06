package com.genius.orla.UI.home.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.genius.orla.R
import com.genius.orla.UI.home.MainSliderFragment

class MainSliderAdapter(fm: FragmentManager?, val num_fragment : Int) : FragmentStatePagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        var fragment : MainSliderFragment = MainSliderFragment()
        var bundle : Bundle = Bundle(1)
        when(position){
            0-> {
                bundle.putInt("background_url", R.drawable.banner)
                bundle.putInt("num", 1)
            }
            1-> {
                bundle.putInt("background_url", R.drawable.banner)
                bundle.putInt("num", 2)
            }
            2-> {
                bundle.putInt("background_url", R.drawable.banner)
                bundle.putInt("num", 3)
            }
        }
        fragment.arguments = bundle
        return fragment
    }

    override fun getCount(): Int {
        return num_fragment
    }
}