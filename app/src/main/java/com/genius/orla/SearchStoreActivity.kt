package com.genius.orla

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationServices

class SearchStoreActivity : AppCompatActivity() {

    val TAG = "SearchStoreActivity"
    var latitude : Double? = null
    var longitude : Double? = null

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
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }

        var fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient.lastLocation
                .addOnSuccessListener { location ->
                    if (location == null) {
                        Log.e(TAG, "location get fail")
                    } else {
                        Log.d(TAG, "${location.latitude},${location.longitude}")
                        latitude = location.latitude
                        longitude = location.longitude
                    }
                }
                .addOnFailureListener {
                    Log.e(TAG,"location error ${it.message}")
                    it.printStackTrace()
                }
    }
}
