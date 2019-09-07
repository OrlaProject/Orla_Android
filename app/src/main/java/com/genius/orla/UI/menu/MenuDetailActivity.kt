package com.genius.orla.UI.menu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import com.genius.orla.R


import kotlinx.android.synthetic.main.activity_menu_detail.*
import org.jetbrains.anko.startActivity


class MenuDetailActivity : AppCompatActivity() {

    var count : Int = 1
    var price : Int = 3800

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_detail)

        setContent()
        setOnBtnClickListener()
        setOnClickListener()
    }

    private fun setContent() {
        txt_menu_detail_act_count.text = count.toString()
    }

    private fun setOnClickListener() {
        setClickListenerOnRelativeView(rl_ac_menu_detail_temp_ice,txt_menu_detail_ice)
        setClickListenerOnRelativeView(rl_ac_menu_detail_temp_hot,txt_menu_detail_hot)
        setClickListenerOnRelativeView(rl_ac_menu_detail_cup_individual,txt_menu_detail_cup)
        setClickListenerOnRelativeView(rl_ac_menu_detail_cup_mug,txt_menu_detail_mug)
        setClickListenerOnRelativeView(rl_ac_menu_detail_cup_take_out,txt_menu_detail_once)
        setClickListenerOnRelativeView(rl_ac_menu_detail_size_tall,txt_menu_detail_tall)
        setClickListenerOnRelativeView(rl_ac_menu_detail_size_medium,txt_menu_detail_medium)
        setClickListenerOnRelativeView(rl_ac_menu_detail_size_large,txt_menu_detail_large)
    }

    private fun setClickListenerOnRelativeView(relativeLayout: RelativeLayout, textView: TextView) {
        relativeLayout.setOnClickListener {
            if(!relativeLayout.isSelected){
                reverseBtn(relativeLayout,textView)
            }else{
                relativeLayout.isSelected = true
                textView.setTextColor(Color.parseColor("#ffffff"))
            }
        }
    }

    private fun reverseBtn(relativeLayout: RelativeLayout, textView: TextView) {
        when(relativeLayout){
            //온도
            rl_ac_menu_detail_temp_ice ->{
                initTempBtnFlag()
                relativeLayout.isSelected = true
                textView.setTextColor(Color.parseColor("#ffffff"))
            }

            rl_ac_menu_detail_temp_hot ->{
                initTempBtnFlag()
                relativeLayout.isSelected = true
                textView.setTextColor(Color.parseColor("#ffffff"))
            }

            //컵
            rl_ac_menu_detail_cup_mug ->{
                initCupBtnFlag()
                relativeLayout.isSelected = true
                textView.setTextColor(Color.parseColor("#ffffff"))
            }

            rl_ac_menu_detail_cup_take_out ->{
                initCupBtnFlag()
                relativeLayout.isSelected = true
                textView.setTextColor(Color.parseColor("#ffffff"))
            }

            rl_ac_menu_detail_cup_individual ->{
                initCupBtnFlag()
                relativeLayout.isSelected = true
                textView.setTextColor(Color.parseColor("#ffffff"))
            }

            //크기
            rl_ac_menu_detail_size_tall ->{
                initSizeBtnFlag()
                relativeLayout.isSelected = true
                textView.setTextColor(Color.parseColor("#ffffff"))
            }

            rl_ac_menu_detail_size_large ->{
                initSizeBtnFlag()
                relativeLayout.isSelected = true
                textView.setTextColor(Color.parseColor("#ffffff"))
            }

            rl_ac_menu_detail_size_medium ->{
                initSizeBtnFlag()
                relativeLayout.isSelected = true
                textView.setTextColor(Color.parseColor("#ffffff"))
            }

        }
    }

    private fun initTempBtnFlag() {
        rl_ac_menu_detail_temp_ice.isSelected = false
        rl_ac_menu_detail_temp_hot.isSelected = false

        txt_menu_detail_ice.setTextColor(Color.parseColor("#a2bfff"))
        txt_menu_detail_hot.setTextColor(Color.parseColor("#a2bfff"))
    }


    private fun initCupBtnFlag() {

        rl_ac_menu_detail_cup_individual.isSelected = false
        rl_ac_menu_detail_cup_mug.isSelected = false
        rl_ac_menu_detail_cup_take_out.isSelected = false

        txt_menu_detail_cup.setTextColor(Color.parseColor("#a2bfff"))
        txt_menu_detail_mug.setTextColor(Color.parseColor("#a2bfff"))
        txt_menu_detail_once.setTextColor(Color.parseColor("#a2bfff"))
    }

    private fun initSizeBtnFlag() {
        rl_ac_menu_detail_size_large.isSelected = false
        rl_ac_menu_detail_size_medium.isSelected = false
        rl_ac_menu_detail_size_tall.isSelected = false

        txt_menu_detail_tall.setTextColor(Color.parseColor("#a2bfff"))
        txt_menu_detail_medium.setTextColor(Color.parseColor("#a2bfff"))
        txt_menu_detail_large.setTextColor(Color.parseColor("#a2bfff"))

    }

    private fun setOnBtnClickListener() {

        btn_ac_menu_detail_mino.setOnClickListener {
            if (count > 0) {

                count -= 1
                txt_menu_detail_act_count.text = count.toString()

                txt_price_menu_detail.text = (count*price).toString()+"원"
            }
        }

        btn_ac_menu_detail_plus.setOnClickListener {
            if (count >= 0) {

                count += 1
                txt_menu_detail_act_count.text = (count).toString()

                txt_price_menu_detail.text = (count*price).toString()+"원"
            }
        }

        btn_ac_menu_detail_info_check.setOnClickListener {

            startActivity<MenuDetailInfoActivity>()
        }

    }


}
