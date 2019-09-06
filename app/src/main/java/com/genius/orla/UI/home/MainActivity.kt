package com.genius.orla.UI.home

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import com.genius.orla.R
import com.genius.orla.UI.home.adapter.MainSliderAdapter
import com.genius.orla.UI.menu.MenuActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    var progressNum: Int = 20

    var coupon_num: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setMainSlider()
        setContent()
        setOnBtnClickListener()
    }

    private fun setContent() {
        progress_main.progress = progressNum
        txt_main_act_coupon_count.text = coupon_num.toString()
        txt_main_act_left_drink.text = (10 - progressNum/10).toString()
    }

    private fun setOnBtnClickListener() {
        btn_main_act_orla_order.setOnClickListener {
            startActivity<MenuActivity>()
        }

        img_main_act_qr.setOnClickListener {
            //QR코드 액티비티로 넘어가기
        }
    }

    private fun setMainSlider() {
        vp_main_act_slider.adapter = MainSliderAdapter(supportFragmentManager, 3)
        vp_main_act_slider.offscreenPageLimit = 2
    }

}
