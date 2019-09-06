package com.genius.orla

import android.Manifest
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.activity_search_store.*
import java.io.IOException
import java.util.*

class SearchStoreActivity : AppCompatActivity() {

    val TAG = "SearchStoreActivity"

    var position: LatLng? = null

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
    }

    private fun setOnBtnClickListener() {
        //현재위치 조회 버튼 눌렀을 때 현재 위치 요청 합니다.
        button.setOnClickListener {
            getPermission()
        }
    }


    internal var locationCallback: LocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult?) {
            super.onLocationResult(locationResult)

            val locationList = locationResult!!.locations

            if (locationList.size > 0) {//locationResult에서 얻어온 location이 있을 때
                var location = locationList[locationList.size - 1] // location은 locationList 배열의 마지막! (제일 최근위치(?))
                //location = locationList.get(0);

                var currentPosition = LatLng(location!!.latitude, location!!.longitude) // 최근위치.

                Log.d(TAG, "onLocationResult : ${location!!.latitude}, ${location!!.longitude}")
                textView.text = getGeocode(currentPosition)
            }
        }
    }


    private fun getPermission() {

        val hasFineLocationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        val hasCoarseLocationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)

        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED && hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED) {
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
            return
        }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient.lastLocation
                .addOnSuccessListener { location ->
                    if (location == null) {
                        Log.e(TAG, "location get fail")
                    } else {
                        Log.d(TAG, "${location.latitude},${location.longitude}")
                        position = LatLng(location.latitude, location.longitude)
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
            Log.v(TAG, "지오코더 서비스 사용 불가")
            return "지오코더 서비스 사용불가"
        } catch (illegalArgumentException: IllegalAccessException) {
            Toast.makeText(this, "잘못된 GPS 좌표입니다.", Toast.LENGTH_LONG).show()
            return "잘못된 GPS 좌표"
        }

        if (addresses == null || addresses.size == 0) {
            Log.v("LocationMainActivity", "주소 미발견")
            return "주소 미발견"
        } else {
            val address = addresses[0]
            return address.getAddressLine(0).toString()
        }
    }

    override fun onPause() {
        super.onPause()
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }


}




