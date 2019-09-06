package com.genius.orla.UI.order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.genius.orla.R
import kotlinx.android.synthetic.main.activity_check_order.*
import org.jetbrains.anko.startActivity

class CheckOrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_order)

        setOnBtnClickListener()

    }

    private fun setOnBtnClickListener() {
        btn_check_order_check_material.setOnClickListener {
            startActivity<OrderMaterialActivity>()
        }
    }
}
