package com.genius.orla.UI.order

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.genius.orla.R
import com.genius.orla.UI.menu.MenuDetailInfoActivity
import kotlinx.android.synthetic.main.activity_check_order.*
import kotlinx.android.synthetic.main.toolbar_check_order.*
import org.jetbrains.anko.custom.style
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.textColor
import org.jetbrains.anko.toast

class CheckOrderActivity : AppCompatActivity() {

    var orderStatus: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_order)

        setOnBtnClickListener()

        setStatus(orderStatus)
    }

    private fun setStatus(orderStatus: Int) {
        when (orderStatus) {
            1 -> {
                img_check_order_act_order_complete.visibility = View.VISIBLE
                txt_check_order_act_order_complete.setTextColor(Color.parseColor("#3468ff"))

                img_check_order_act_making.visibility = View.INVISIBLE
                txt_check_order_act_making.setTextColor(Color.parseColor("#43484b"))
                img_check_order_act_make_complete.visibility = View.INVISIBLE
                txt_check_order_act_make_complete.setTextColor(Color.parseColor("#43484b"))
                img_check_order_act_finish.visibility = View.INVISIBLE
                txt_check_order_act_finish.setTextColor(Color.parseColor("#43484b"))

                //버튼 비활성화
                btn_check_order_check_material.run {
                    setTextColor(Color.parseColor("#9b9b9b"))
                    isEnabled = false
                }
            }
            2 -> {
                img_check_order_act_order_complete.visibility = View.INVISIBLE
                txt_check_order_act_order_complete.setTextColor(Color.parseColor("#43484b"))

                img_check_order_act_making.visibility = View.VISIBLE
                txt_check_order_act_making.setTextColor(Color.parseColor("#3468ff"))

                img_check_order_act_make_complete.visibility = View.INVISIBLE
                txt_check_order_act_make_complete.setTextColor(Color.parseColor("#43484b"))
                img_check_order_act_finish.visibility = View.INVISIBLE
                txt_check_order_act_finish.setTextColor(Color.parseColor("#43484b"))


                //버튼 활성화
                btn_check_order_check_material.run {
                    setTextColor(Color.parseColor("#43484b"))
                    isEnabled = true
                }
            }
            3 -> {
                img_check_order_act_order_complete.visibility = View.INVISIBLE
                txt_check_order_act_order_complete.setTextColor(Color.parseColor("#43484b"))
                img_check_order_act_making.visibility = View.INVISIBLE
                txt_check_order_act_making.setTextColor(Color.parseColor("#43484b"))

                img_check_order_act_make_complete.visibility = View.VISIBLE
                txt_check_order_act_make_complete.setTextColor(Color.parseColor("#3468ff"))

                img_check_order_act_finish.visibility = View.INVISIBLE
                txt_check_order_act_finish.setTextColor(Color.parseColor("#43484b"))

                //버튼 활성화
                btn_check_order_check_material.run {
                    setTextColor(Color.parseColor("#43484b"))
                    isEnabled = true
                }
            }
            4 -> {
                img_check_order_act_order_complete.visibility = View.INVISIBLE
                txt_check_order_act_order_complete.setTextColor(Color.parseColor("#43484b"))
                img_check_order_act_making.visibility = View.INVISIBLE
                txt_check_order_act_making.setTextColor(Color.parseColor("#43484b"))
                img_check_order_act_make_complete.visibility = View.INVISIBLE
                txt_check_order_act_make_complete.setTextColor(Color.parseColor("#43484b"))

                img_check_order_act_finish.visibility = View.VISIBLE
                txt_check_order_act_finish.setTextColor(Color.parseColor("#3468ff"))

                //버튼 활성화
                btn_check_order_check_material.run {
                    setTextColor(Color.parseColor("#43484b"))
                    isEnabled = true
                }
            }
            else -> return
        }
    }

    private fun setOnBtnClickListener() {
        btn_check_order_check_material.setOnClickListener {
            startActivity<OrderMaterialActivity>()
        }

        btn_ac_check_order_detail.setOnClickListener {
            startActivity<MenuDetailInfoActivity>()
        }

        btn_check_order_toolbar_reload.setOnClickListener {
            if (orderStatus == 1) {
                orderStatus = 2
                setStatus(2)
            } else if (orderStatus == 2) {
                orderStatus = 3
                setStatus(3)
            } else if (orderStatus == 3) {
                orderStatus = 4
                setStatus(4)
            } else if (orderStatus == 4) {
                orderStatus = 1
                setStatus(1)
            }
        }
    }
}
