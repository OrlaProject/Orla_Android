package com.genius.orla.UI.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.os.Handler
import android.view.View
import com.genius.orla.R
import com.genius.orla.UI.home.adapter.MainSliderAdapter
import com.genius.orla.UI.menu.MenuActivity
import com.genius.orla.UI.menu.MenuDetailInfoActivity
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    var progressNum: Int = 20

    var coupon_num: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setMainSlider()
        setContent()
        setOnBtnClickListener()

        Handler().postDelayed({


            iv_ac_main_farmer.visibility = View.GONE

        }, 4000)
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

            initScan()


        }
    }


    private fun initScan(){
        IntentIntegrator(this).initiateScan()
    }



    private fun setMainSlider() {
        vp_main_act_slider.adapter = MainSliderAdapter(supportFragmentManager, 3)
        vp_main_act_slider.offscreenPageLimit = 2
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)


        //check if result is scan any QR
        if (result != null){

            //the result data is null or empty then
            if (result.contents == null){

                toast("데이터가 없습니다.")



            }else{

                startActivity<MenuDetailInfoActivity>()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }


}
