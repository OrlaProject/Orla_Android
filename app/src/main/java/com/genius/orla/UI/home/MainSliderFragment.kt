package com.genius.orla.UI.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.fragment_main_slider.*
import android.content.Intent
import android.net.Uri
import com.genius.orla.R


/**
 * A simple [Fragment] subclass.
 */
class MainSliderFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_slider, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setContent()
        setOnBtnClickListener()
    }

    private fun setOnBtnClickListener() {
        img_main_slider_frag.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nonghyupmall.com/MC53030R/inqExhStPlanDetailList.nh?crnC=000644&chanC=1102&brnC=0000&mediaD=00&mbT=00&ctgrStp=1"))
            startActivity(intent)
        }
    }

    private fun setContent() {

        val img_url : Int = arguments!!.getInt("background_url")
        val slider_num : Int = arguments!!.getInt("num")

        Glide.with(context!!).load(img_url).into(img_main_slider_frag)
        txt_main_slider_frag_num.text = slider_num.toString()+"/5"

    }


}
