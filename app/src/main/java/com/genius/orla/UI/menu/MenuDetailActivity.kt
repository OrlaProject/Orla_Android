package com.genius.orla.UI.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.genius.orla.R
import kotlinx.android.synthetic.main.activity_menu_detail.*
import org.jetbrains.anko.startActivity

class MenuDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_detail)

        setOnBtnClickListener()
    }

    private fun setOnBtnClickListener() {


        btn_ac_menu_detail_info_check.setOnClickListener {

            startActivity<MenuDetailInfoActivity>()
        }

    }


}
