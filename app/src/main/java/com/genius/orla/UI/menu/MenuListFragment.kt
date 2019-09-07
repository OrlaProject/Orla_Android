package com.genius.orla.UI.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.genius.orla.Data.MenuListData

import com.genius.orla.R
import kotlinx.android.synthetic.main.fragment_menu_list.*

/**
 * A simple [Fragment] subclass.
 */
class MenuListFragment : Fragment() {

    companion object {
        fun newInstance(num: Int): MenuListFragment {
            val bundle: Bundle = Bundle()
            bundle.putInt("tab", num)

            val fragment = MenuListFragment()

            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_list, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var tabNum: Int = arguments!!.getInt("tab")

        setTabArrayList(tabNum)

        }

    private fun setTabArrayList(tabNum: Int) {
        when(tabNum){
            0 -> {
                var menulist: ArrayList<MenuListData> = ArrayList()
                menulist.add(MenuListData("단호박라떼", "", 3200, "", "피로회복, 신진대사 활성화로 활력에 탁월한 친환경 호박 주스"))
                menulist.add(MenuListData("사과 케일 블랜디드", "", 3200, "", "‘저칼로리 + 식이섬유’로 건강과 미용을 레벨업 시켜주는 사과주스"))
                menulist.add(MenuListData("스윗 케일", "", 3200, "", "숙취해소, 시력보호, 변비 해소를 해주는 상추주스"))
                menulist.add(MenuListData("라즈베리 주스", "KakaoTalk_Photo_2019-09-07-11-23-10.png", 3700, "", "비타민C 함유로 활력에 탁월한 친환경 라즈베리 주스"))
                menulist.add(MenuListData("단호박라떼", "", 3200, "", "피로회복, 신진대사 활성화로 활력에 탁월한 친환경 호박 주스"))

                setAdapter(menulist)
            }
        }
    }

    private fun setAdapter(menulist: java.util.ArrayList<MenuListData>) {
        var menuListRecyclcerViewAdapter = MenuListRecyclcerViewAdapter(context!!, menulist)
        rv_fg_my_page_delivery_list.adapter = menuListRecyclcerViewAdapter
        rv_fg_my_page_delivery_list.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    }


}
