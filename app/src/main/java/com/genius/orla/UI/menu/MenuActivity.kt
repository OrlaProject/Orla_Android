package com.genius.orla.UI.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.RelativeLayout
import com.genius.orla.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        configureTopTab()


    }


    private fun configureTopTab() {

        vp_ac_menu.adapter = MenuCategoryTabAdapter(supportFragmentManager, 4)
        tl_ac_menu_toptab.setupWithViewPager(vp_ac_menu)
        val toptab : View = this.layoutInflater.inflate(R.layout.tab_menu_category,null,false)

        tl_ac_menu_toptab.getTabAt(0)!!.customView = toptab.findViewById(R.id.rl_tab_menu_category_drink) as RelativeLayout
        tl_ac_menu_toptab.getTabAt(1)!!.customView = toptab.findViewById(R.id.rl_tab_menu_category_salad) as RelativeLayout
        tl_ac_menu_toptab.getTabAt(2)!!.customView = toptab.findViewById(R.id.rl_tab_menu_category_sandwich)as RelativeLayout
        tl_ac_menu_toptab.getTabAt(3)!!.customView = toptab.findViewById(R.id.rl_tab_menu_category_fruit) as RelativeLayout


    }
}
