package com.genius.orla.UI.menu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.genius.orla.Data.MenuListData
import com.genius.orla.R


class MenuListRecyclcerViewAdapter (val ctx: Context, val menulist : ArrayList<MenuListData>) : RecyclerView.Adapter<MenuListRecyclcerViewAdapter.Holder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_fg_menu_list, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int = menulist.size


    override fun onBindViewHolder(holer: Holder, position: Int) {
        holer.title.text = menulist[position].title
        holer.content.text = menulist[position].content
        holer.price.text = menulist[position].price.toString()

    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title : TextView = itemView.findViewById(R.id.tv_rv_menu_list_title) as TextView
        val content : TextView = itemView.findViewById(R.id.tv_rv_menu_list_content) as TextView
        val price : TextView = itemView.findViewById(R.id.tv_rv_menu_list_price) as TextView



    }



}