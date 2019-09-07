package com.genius.orla.UI.order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.genius.orla.R
import kotlinx.android.synthetic.main.toolbar_order_material.*

class OrderMaterialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_material)

        setOnBtnClickListener()
    }

    private fun setOnBtnClickListener() {
        img_order_material_toolbar_back.setOnClickListener {
            finish()
        }

        img_order_material_toolbar_close.setOnClickListener {
            finish()
        }
    }
}
