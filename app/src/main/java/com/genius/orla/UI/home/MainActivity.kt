package com.genius.orla.UI.home

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import com.genius.orla.R
import com.genius.orla.UI.home.adapter.MainSliderAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setMainSlider()
    }

    private fun setMainSlider() {
        vp_main_act_slider.adapter = MainSliderAdapter(supportFragmentManager,3)
        vp_main_act_slider.offscreenPageLimit = 2
    }
}
