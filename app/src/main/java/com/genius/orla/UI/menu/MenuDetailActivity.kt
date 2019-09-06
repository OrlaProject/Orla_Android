package com.genius.orla.UI.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.genius.orla.R
<<<<<<< HEAD
import org.jetbrains.anko.toast
=======
import kotlinx.android.synthetic.main.activity_menu_detail.*
import org.jetbrains.anko.startActivity
>>>>>>> 31519500321eb208ff7a4f98f0ba163cd05554e0

class MenuDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_detail)

        setOnBtnClickListener()
    }

    private fun setOnBtnClickListener() {


<<<<<<< HEAD
=======
        btn_ac_menu_detail_info_check.setOnClickListener {

            startActivity<MenuDetailInfoActivity>()
        }

>>>>>>> 31519500321eb208ff7a4f98f0ba163cd05554e0
    }


}
