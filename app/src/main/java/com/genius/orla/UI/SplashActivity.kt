package com.genius.orla.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bumptech.glide.Glide
import com.genius.orla.R
import com.genius.orla.UI.home.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Glide.with(applicationContext).load(R.drawable.splash).into(img_splash)

        Handler().postDelayed({

            startActivity<MainActivity>()

        }, 2000)
    }
}
