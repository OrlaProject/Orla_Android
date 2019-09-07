package com.genius.orla.UI.menu.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.genius.orla.Data.MenuListData
import com.genius.orla.R
import com.genius.orla.UI.fruit.FruitDetailActivity
import com.genius.orla.UI.menu.MenuActivity
import com.genius.orla.UI.menu.MenuDetailActivity
import de.hdodenhof.circleimageview.CircleImageView


class MenuListRecyclcerViewAdapter(val ctx: Context, val menulist: ArrayList<MenuListData>) : RecyclerView.Adapter<MenuListRecyclcerViewAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_fg_menu_list, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int = menulist.size


    override fun onBindViewHolder(holer: Holder, position: Int) {
        holer.title.text = menulist[position].title
        holer.content.text = menulist[position].content
        holer.price.text = menulist[position].price.toString()

        Glide.with(ctx).load(menulist[position].thumbnail).into(holer.thumb)
        holer.container.setOnClickListener {
            if(menulist[position].title == "나만의 1인 과일"){
                val intent : Intent = Intent(ctx,FruitDetailActivity::class.java)
                startActivity(ctx,intent,null)

            }else {
                val intent: Intent = Intent(ctx, MenuDetailActivity::class.java)
                startActivity(ctx, intent, null)
            }
        }

        if(menulist[position].price.toString() == "3800")
        holer.mark.setImageResource(R.drawable.moo_you_big_icon)

        if(menulist[position].price.toString() == "3200")
            holer.mark.setImageResource(R.drawable.youkinong_icon)

    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mark: ImageView = itemView.findViewById(R.id.iv_rv_menu_list_class) as ImageView
        val container: RelativeLayout = itemView.findViewById(R.id.rl_rv_item_menu_list) as RelativeLayout
        val title: TextView = itemView.findViewById(R.id.tv_rv_menu_list_title) as TextView
        val content: TextView = itemView.findViewById(R.id.tv_rv_menu_list_content) as TextView
        val price: TextView = itemView.findViewById(R.id.tv_rv_menu_list_price) as TextView
        val thumb: CircleImageView = itemView.findViewById(R.id.iv_rv_menu_list_thumbnail) as CircleImageView


    }


}