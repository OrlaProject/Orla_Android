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
                menulist.add(MenuListData("단호박 라떼", "https://cdn.pixabay.com/photo/2014/09/23/14/11/pumpkins-457716__480.jpg", 3200, "", "피로회복, 신진대사 활성화로 활력에 탁월한 친환경 호박 주스"))
                menulist.add(MenuListData("사과 케일 블랜디드", "https://cdn.pixabay.com/photo/2014/10/15/22/06/apples-490474__480.jpg", 3200, "", "‘저칼로리 + 식이섬유’로 건강과 미용을 레벨업 시켜주는 사과주스"))
                menulist.add(MenuListData("스윗 케일", "https://cdn.pixabay.com/photo/2017/08/08/13/37/green-smoothie-2611407__480.jpg", 3200, "", "숙취해소, 시력보호, 변비 해소를 해주는 상추주스"))
                menulist.add(MenuListData("라즈베리 주스", "https://cdn.pixabay.com/photo/2010/12/13/10/05/background-2277__480.jpg", 3700, "https://t1.daumcdn.net/cfile/tistory/2574854355A9AFD015", "비타민C 함유로 활력에 탁월한 친환경 라즈베리 주스"))
                menulist.add(MenuListData("수박 주스", "https://cdn.pixabay.com/photo/2010/12/13/10/18/watermelon-2636__480.jpg", 3200, "", "한여름을 시원하게 식혀주는 달콤,상큼 수박주스"))

                setAdapter(menulist)
            }
            //샐러드
            1-> {
                var saladlist: ArrayList<MenuListData> = ArrayList()
                saladlist.add(MenuListData("그린 레드 샐러드", "https://cdn.pixabay.com/photo/2018/03/09/17/39/paprika-3212137__480.jpg", 4800, "", "피로회복, 신진대사 활성화로 활력에 탁월한 친환경 호박 주스"))
                saladlist.add(MenuListData("치즈 앤 그리너리 샐러드", "https://cdn.pixabay.com/photo/2016/08/09/10/30/tomatoes-1580273__480.jpg", 4100, "", "‘저칼로리 + 식이섬유’로 건강과 미용을 레벨업 시켜주는 사과주스"))
                saladlist.add(MenuListData("올라 프리미엄 샐러드", "https://cdn.pixabay.com/photo/2017/03/10/13/49/fast-food-2132863__480.jpg", 3200, "", "숙취해소, 시력보호, 변비 해소를 해주는 상추주스"))
                saladlist.add(MenuListData("비건 샐러드", "https://cdn.pixabay.com/photo/2016/10/31/18/23/salad-1786327__480.jpg", 3200, "", "숙취해소, 시력보호, 변비 해소를 해주는 상추주스"))
                saladlist.add(MenuListData("스윗 에그 샐러드", "https://cdn.pixabay.com/photo/2019/09/01/19/28/salad-4445887__480.jpg", 3200, "", "숙취해소, 시력보호, 변비 해소를 해주는 상추주스"))

                setAdapter(saladlist)
            }
            //샌드위치
            2->{
                var sandlist: ArrayList<MenuListData> = ArrayList()

                sandlist.add(MenuListData("해커톤 샌드위치", "https://cdn.pixabay.com/photo/2016/03/05/20/02/appetizer-1238615__480.jpg", 4800, "", "피로회복, 신진대사 활성화로 활력에 탁월한 친환경 호박 주스"))
                sandlist.add(MenuListData("스윗 에그 샌드위치", "https://cdn.pixabay.com/photo/2017/09/18/14/49/egg-sandwich-2761894__480.jpg", 4100, "", "‘저칼로리 + 식이섬유’로 건강과 미용을 레벨업 시켜주는 사과주스"))
                sandlist.add(MenuListData("올라 야채 프리미엄", "https://cdn.pixabay.com/photo/2017/03/10/13/49/fast-food-2132863__480.jpg", 3200, "", "숙취해소, 시력보호, 변비 해소를 해주는 상추주스"))
                sandlist.add(MenuListData("비건 샌드위치", "https://cdn.pixabay.com/photo/2015/08/16/12/02/sandwich-890822__480.jpg", 3200, "", "숙취해소, 시력보호, 변비 해소를 해주는 상추주스"))

                setAdapter(sandlist)

            }
            //과일
            3-> {

                var fruitList: ArrayList<MenuListData> = ArrayList()

                fruitList.add(MenuListData("나만의 1인 과일", "https://cdn.pixabay.com/photo/2016/03/05/20/02/appetizer-1238615__480.jpg", 4800, "", "피로회복, 신진대사 활성화로 활력에 탁월한 친환경 호박 주스"))
                fruitList.add(MenuListData("토마토", "https://cdn.pixabay.com/photo/2017/09/18/14/49/egg-sandwich-2761894__480.jpg", 4100, "", "‘저칼로리 + 식이섬유’로 건강과 미용을 레벨업 시켜주는 사과주스"))
                fruitList.add(MenuListData("올라", "https://cdn.pixabay.com/photo/2017/03/10/13/49/fast-food-2132863__480.jpg", 3200, "", "숙취해소, 시력보호, 변비 해소를 해주는 상추주스"))
                fruitList.add(MenuListData("비건 샌드위치", "https://cdn.pixabay.com/photo/2015/08/16/12/02/sandwich-890822__480.jpg", 3200, "", "숙취해소, 시력보호, 변비 해소를 해주는 상추주스"))

                setAdapter(fruitList)

            }
        }
    }

    private fun setAdapter(menulist: java.util.ArrayList<MenuListData>) {
        var menuListRecyclcerViewAdapter = MenuListRecyclcerViewAdapter(context!!, menulist)
        rv_fg_menu_list.adapter = menuListRecyclcerViewAdapter
        rv_fg_menu_list.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    }


}
