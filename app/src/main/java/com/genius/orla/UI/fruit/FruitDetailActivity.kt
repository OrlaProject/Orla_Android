package com.genius.orla.UI.fruit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.genius.orla.R
import kotlinx.android.synthetic.main.activity_check_order.*
import kotlinx.android.synthetic.main.activity_fruit_detail.*
import org.jetbrains.anko.toast

class FruitDetailActivity : AppCompatActivity() {


    var grapeCount: Int = 1
    var appleCount: Int = 1
    var tomatoCount: Int = 1

    var totalFruit: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit_detail)

        setContent()
        setOnBtnClickListener()
    }

    private fun setContent() {
        txt_fruit_act_grape_count.text = grapeCount.toString()
        txt_fruit_act_apple_count.text = appleCount.toString()
        txt_fruit_act_tomato_count.text = tomatoCount.toString()

        txt_fruit_act_maximum.text = totalFruit.toString()
    }

    private fun setOnBtnClickListener() {
        // 포도
        btn_fruit_act_grape_minus.setOnClickListener {
            if (grapeCount > 0) {

                grapeCount -= 1
                txt_fruit_act_grape_count.text = grapeCount.toString()

                txt_fruit_act_maximum.text = (appleCount + grapeCount + tomatoCount).toString()
            }
        }

        btn_fruit_act_grape_plus.setOnClickListener {
            if (grapeCount >= 0) {

                grapeCount += 1
                txt_fruit_act_grape_count.text = (grapeCount).toString()

                txt_fruit_act_maximum.text = (appleCount + grapeCount + tomatoCount).toString()
            }
        }

        //사과

        btn_fruit_act_apple_minus.setOnClickListener {
            if (appleCount > 0) {

                appleCount -= 1
                txt_fruit_act_apple_count.text = (appleCount).toString()

                txt_fruit_act_maximum.text = (appleCount + grapeCount + tomatoCount).toString()
            }
        }

        btn_fruit_act_apple_plus.setOnClickListener {
            if (appleCount >= 0) {
                appleCount += 1
                txt_fruit_act_apple_count.text = (appleCount).toString()

                txt_fruit_act_maximum.text = (appleCount + grapeCount + tomatoCount).toString()
            }
        }

        //토마토

        btn_fruit_act_tomato_minus.setOnClickListener {
            if (tomatoCount > 0) {
                tomatoCount -= 1
                txt_fruit_act_tomato_count.text = (tomatoCount).toString()

                txt_fruit_act_maximum.text = (appleCount + grapeCount + tomatoCount).toString()
            }
        }

        btn_fruit_act_tomato_plus.setOnClickListener {
            if (tomatoCount >= 0) {
                tomatoCount += 1
                txt_fruit_act_tomato_count.text = (tomatoCount).toString()

                txt_fruit_act_maximum.text = (appleCount + grapeCount + tomatoCount).toString()
            }
        }
    }
}
