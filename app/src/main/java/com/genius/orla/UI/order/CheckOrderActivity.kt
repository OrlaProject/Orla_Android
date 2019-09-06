package com.genius.orla.UI.order

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.genius.orla.R
import kotlinx.android.synthetic.main.activity_check_order.*
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
                img_check_order_act_order_complete.isSelected = true
                txt_check_order_act_order_complete.setTextColor(Color.parseColor(R.color.lightish_blue.toString()))

                img_check_order_act_making.isSelected = false
                txt_check_order_act_making.setTextColor(Color.parseColor(R.color.charcoal_grey.toString()))
                img_check_order_act_make_complete.isSelected = false
                txt_check_order_act_make_complete.setTextColor(Color.parseColor(R.color.charcoal_grey.toString()))
                img_check_order_act_finish.isSelected = false
                txt_check_order_act_finish.setTextColor(Color.parseColor(R.color.charcoal_grey.toString()))

                //버튼 비활성화
                btn_check_order_check_material.run {
                    setTextColor(Color.parseColor("#9b9b9b"))
                    isEnabled = false
                    toast("제조가 시작될 때까지 기다려 주세요.")
                }
            }
            2 -> {
                img_check_order_act_order_complete.isSelected = false
                txt_check_order_act_order_complete.setTextColor(Color.parseColor(R.color.charcoal_grey.toString()))

                img_check_order_act_making.isSelected = true
                txt_check_order_act_making.setTextColor(Color.parseColor(R.color.lightish_blue.toString()))
                img_check_order_act_make_complete.isSelected = false
                txt_check_order_act_make_complete.setTextColor(Color.parseColor(R.color.charcoal_grey.toString()))
                img_check_order_act_finish.isSelected = false
                txt_check_order_act_finish.setTextColor(Color.parseColor(R.color.charcoal_grey.toString()))


                //버튼 활성화
                btn_check_order_check_material.run {
                    setTextColor(Color.parseColor(R.color.charcoal_grey.toString()))
                    isEnabled = true
                }
            }
            3 -> {
                img_check_order_act_order_complete.isSelected = false
                txt_check_order_act_order_complete.setTextColor(Color.parseColor(R.color.charcoal_grey.toString()))
                img_check_order_act_making.isSelected = false
                txt_check_order_act_making.setTextColor(Color.parseColor(R.color.charcoal_grey.toString()))

                img_check_order_act_make_complete.isSelected = true
                txt_check_order_act_make_complete.setTextColor(Color.parseColor(R.color.lightish_blue.toString()))
                img_check_order_act_finish.isSelected = false
                txt_check_order_act_finish.setTextColor(Color.parseColor(R.color.charcoal_grey.toString()))

                //버튼 활성화
                btn_check_order_check_material.run {
                    setTextColor(Color.parseColor(R.color.charcoal_grey.toString()))
                    isEnabled = true
                }
            }
            4 -> {
                img_check_order_act_order_complete.isSelected = false
                txt_check_order_act_order_complete.setTextColor(Color.parseColor(R.color.charcoal_grey.toString()))
                img_check_order_act_making.isSelected = false
                txt_check_order_act_making.setTextColor(Color.parseColor(R.color.charcoal_grey.toString()))
                img_check_order_act_make_complete.isSelected = false
                txt_check_order_act_make_complete.setTextColor(Color.parseColor(R.color.charcoal_grey.toString()))

                img_check_order_act_finish.isSelected = true
                txt_check_order_act_finish.setTextColor(Color.parseColor(R.color.lightish_blue.toString()))

                //버튼 활성화
                btn_check_order_check_material.run {
                    setTextColor(Color.parseColor(R.color.charcoal_grey.toString()))
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
    }
}
