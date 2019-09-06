package com.genius.orla

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat

class SearchStoreActivity : AppCompatActivity() {

    val TAG = "SearchStoreActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_store)

        setOnBtnClickListener()
    }

    private fun setOnBtnClickListener() {
        //현재위치 조회 버튼 눌렀을 때 현재 위치 요청 합니다.
        requestLocation()
    }

    private fun requestLocation() {
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }
    }
}
