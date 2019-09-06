package com.genius.orla.UI.store.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.genius.orla.R
import com.genius.orla.UI.store.data.StoreListData

class SearchStoreRVAdapter(val ctx: Context, val storeList: ArrayList<StoreListData>) : RecyclerView.Adapter<SearchStoreRVAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_search_store_frag, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = storeList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.store_name.text = storeList[position].store_name
        holder.location.text = storeList[position].location
        holder.how_nearby.text = storeList[position].how_nearby

    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val store_name: TextView = itemView.findViewById(R.id.txt_rv_item_search_store_frag_store) as TextView
        val location: TextView = itemView.findViewById(R.id.txt_rv_item_search_store_frag_location) as TextView
        val how_nearby: TextView = itemView.findViewById(R.id.txt_rv_item_search_store_frag_nearby) as TextView

    }
}