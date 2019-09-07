package com.genius.orla.UI.store.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.genius.orla.R
import com.genius.orla.UI.store.adapter.SearchStoreRVAdapter
import com.genius.orla.UI.store.data.StoreListData
import kotlinx.android.synthetic.main.fragment_search_store.*

class SearchStoreFragment : Fragment() {

    companion object{
        fun newInstance(tab:Int) : SearchStoreFragment{

            val bundle : Bundle = Bundle()
            bundle.putInt("Storetab",tab)

            val fragment = SearchStoreFragment()
            fragment.arguments = bundle

            return fragment
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_store, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var num : Int = arguments!!.getInt("Storetab")
        setTabList(num)



    }

    private fun setTabList(num : Int) {
        when(num){
            0->{
                var storeList : ArrayList<StoreListData> = ArrayList()

                storeList.add(StoreListData("올라 양재점","서울특별시 서초구 양재동 232","0.6km"))
                storeList.add(StoreListData("올라 영등포점","서울특별시 영등포구 영등포동 618-38","12.6km"))
                storeList.add(StoreListData("올라 개포점","서울특별시 강남구 개포동","2.4km"))
                storeList.add(StoreListData("올라 강남1호점","서울특별시 서초구 강남대로61길 19","4.2km"))
                storeList.add(StoreListData("올라 방배점","서울특별시 서초구 방배동 924-11","4.2km"))
                storeList.add(StoreListData("올라 선릉점","서울특별시 강남구 논현동 118-17","4.7km"))
                storeList.add(StoreListData("올라 청담점","서울특별시 강남구 청담동 118-8","6.4km"))

                setAdapter(storeList)

            }
            1->{
                var starStoreList : ArrayList<StoreListData> = ArrayList()

                starStoreList.add(StoreListData("올라 강남1호점","서울특별시 강남구 청담동 118-8","4.2km"))
                starStoreList.add(StoreListData("올라 흑석점","서울특별시 동작구 흑석동 8-32","8.1km"))
                starStoreList.add(StoreListData("올라 이태원점","서울특별시 용산구 이태원동 119-25","9.0km"))

                setAdapter(starStoreList)
            }
        }


    }

    private fun setAdapter(storeList: java.util.ArrayList<StoreListData>) {
        var searchStoreRVAdapter : SearchStoreRVAdapter = SearchStoreRVAdapter(context!!,storeList)

        rv_search_store_frag.run {
            adapter = searchStoreRVAdapter
            layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        }
    }


}
