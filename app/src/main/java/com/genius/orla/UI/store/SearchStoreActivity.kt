package com.genius.orla.UI.store

import android.Manifest
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.genius.orla.R
import com.genius.orla.UI.store.adapter.SearchStoreAdapter
import com.google.android.gms.location.*
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.activity_search_store.*
import java.io.IOException
import java.util.*

class SearchStoreActivity : AppCompatActivity() {

    private val TAG = "SearchStoreActivity"

    lateinit var currentPosition : LatLng

    lateinit var locationRequest: LocationRequest
    lateinit var fusedLocationClient: FusedLocationProviderClient

    lateinit var geocoder: Geocoder

    private val PERMISSIONS_REQUEST_CODE = 100

    internal var REQUIRED_PERMISSIONS =
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_store)

        setOnBtnClickListener()
        setTabLayout()
    }

    private fun setTabLayout() {
        vp_search_store_act.adapter = SearchStoreAdapter(supportFragmentManager, 2)
        tl_search_store_act.setupWithViewPager(vp_search_store_act)
        val toptab : View = this.layoutInflater.inflate(R.layout.tab_menu_search_store,null,false)

        tl_search_store_act.getTabAt(0)!!.customView = toptab.findViewById(R.id.rl_tab_menu_search_store_nearby) as RelativeLayout
        tl_search_store_act.getTabAt(1)!!.customView = toptab.findViewById(R.id.rl_tab_menu_search_store_star) as RelativeLayout

    }

    private fun setOnBtnClickListener() {
        //현재위치 조회 버튼 눌렀을 때 현재 위치를 요청 합니다.
        btn_search_store_act_reload.setOnClickListener {
            getPermission() // 퍼미션 검사
        }
    }

    private fun getPermission() {
        val hasFineLocationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        val hasCoarseLocationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)

        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED && hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED) {
            //퍼미션이 허락되었다면 위치 요청
            requestLocation()
        } else {

            // 퍼미션 거부한 적 있을 때 퍼미션 요청
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])) {
                Toast.makeText(this, "이 앱을 실행하려면 위치 접근 권한이 필요합니다.", Toast.LENGTH_LONG).show()
                ActivityCompat.requestPermissions(
                        this@SearchStoreActivity, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE
                )
            } else {

                //퍼미션 거부한 적 없을 때 퍼미션 요청
                ActivityCompat.requestPermissions(
                        this, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE
                )
            }
        }
    }

    private fun requestLocation() {
        val hasFineLocationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        val hasCoarseLocationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
        if (hasFineLocationPermission != PackageManager.PERMISSION_GRANTED && hasCoarseLocationPermission != PackageManager.PERMISSION_GRANTED) {
            getPermission()
        }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient.lastLocation
                .addOnSuccessListener { location ->
                    if (location == null) {
                        Log.e(TAG, "location get fail")
                    } else {
                        Log.d(TAG, "${location.latitude},${location.longitude}")
                    }
                }
                .addOnFailureListener {
                    Log.e(TAG, "location error ${it.message}")
                    it.printStackTrace()
                }

        locationRequest = LocationRequest.create()
        locationRequest.run {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            interval = 60 * 1000
        }

        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper())
    }

    internal var locationCallback: LocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult?) {
            super.onLocationResult(locationResult)

            val locationList = locationResult!!.locations
            if (locationList.size > 0) {

                var location = locationList[locationList.size - 1]

                currentPosition = LatLng(location!!.latitude, location!!.longitude)
                Log.d(TAG, "onLocationResult : ${location!!.latitude}, ${location!!.longitude}")

                textView.text = "내 위치 : "+getGeocode(currentPosition)
            }
        }
    }

    private fun getGeocode(position: LatLng): String {

        geocoder = Geocoder(this, Locale.getDefault())

        var addresses: List<Address>?

        try {
            addresses = geocoder.getFromLocation(
                    position.latitude,
                    position.longitude,
                    1
            )
        } catch (ioException: IOException) {
            return "지오코더 서비스 사용불가"
        } catch (illegalArgumentException: IllegalAccessException) {
            return "잘못된 GPS 좌표"
        }

        if (addresses == null || addresses.size == 0) {
            return "주소 미발견"
        } else {
            val address = addresses[0]
            return address.getAddressLine(0).toString()
        }
    }

}




