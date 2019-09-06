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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_store, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var storeList : ArrayList<StoreListData> = ArrayList()

        storeList.add(StoreListData("어쩔","안물","1m"))
        storeList.add(StoreListData("어쩔","안물","1m"))
        storeList.add(StoreListData("어쩔","안물","1m"))
        storeList.add(StoreListData("어쩔","안물","1m"))
        storeList.add(StoreListData("어쩔","안물","1m"))

        var searchStoreRVAdapter : SearchStoreRVAdapter = SearchStoreRVAdapter(context!!,storeList)
        rv_search_store_frag.run {
            adapter = searchStoreRVAdapter
            layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        }


    }


}
