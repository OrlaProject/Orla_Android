package com.genius.orla.UI.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.genius.orla.Data.MenuListData

import com.genius.orla.R
import com.genius.orla.UI.menu.adapter.MenuListRecyclcerViewAdapter
import kotlinx.android.synthetic.main.fragment_menu_list.*

/**
 * A simple [Fragment] subclass.
 */
class MenuListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_list, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var menulist : ArrayList<MenuListData> = ArrayList()
        menulist.add(MenuListData("단호박라떼","",3200,"","피로회복, 신진대사 활성화로 활력에 탁월한 친환경 호박 주스"))
        menulist.add(MenuListData("사과주스","",3200,"","피로회복, 신진대사 활성화로 활력에 탁월한 친환경 호박 주스"))
        menulist.add(MenuListData("녹차라떼","",3200,"","피로회복, 신진대사 활성화로 활력에 탁월한 친환경 호박 주스"))
        menulist.add(MenuListData("단호박라떼","",3200,"","피로회복, 신진대사 활성화로 활력에 탁월한 친환경 호박 주스"))
        menulist.add(MenuListData("단호박라떼","",3200,"","피로회복, 신진대사 활성화로 활력에 탁월한 친환경 호박 주스"))

        var menuListRecyclcerViewAdapter= MenuListRecyclcerViewAdapter(context!!, menulist)
        rv_fg_menu_list.adapter = menuListRecyclcerViewAdapter
        rv_fg_menu_list.layoutManager =  LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

    }


}
