package org.wit.hikingtrail.views.hikingtrail

import android.annotation.SuppressLint
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.wit.hikingtrail.helpers.checkLocationPermissions
import org.wit.hikingtrail.helpers.createDefaultLocationRequest
import org.wit.hikingtrail.main.MainApp
import org.wit.hikingtrail.models.Location
import org.wit.hikingtrail.models.HikingtrailModel
import org.wit.hikingtrail.showImagePicker
import org.wit.hikingtrail.views.location.EditLocationView
import timber.log.Timber
import timber.log.Timber.i

class HikingtrailPresenter(private val view: HikingtrailView) {
    private val locationRequest = createDefaultLocationRequest()
    var map: GoogleMap? = null
    var hikingtrail = HikingtrailModel()
    var app: MainApp = view.application as MainApp
    var locationManualyChanged = false;
    //location service
    var locationService: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(view)
    private lateinit var imageIntentLauncher : ActivityResultLauncher<Intent>
    private lateinit var mapIntentLauncher : ActivityResultLauncher<Intent>
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>
    var edit = false;
    private val location = Location(52.245696, -7.139102, 15f)

    init {

        doPermissionLauncher()
        registerImagePickerCallback()
        registerMapCallback()

        if (view.intent.hasExtra("hikingtrail_edit")) {
            edit = true
            hikingtrail = view.intent.extras?.getParcelable("hikingtrail_edit")!!
            view.showHikingtrail(hikingtrail)
        }
        else {

            if (checkLocationPermissions(view)) {
                doSetCurrentLocation()
            }
            hikingtrail.location.lat = location.lat
            hikingtrail.location.lng = location.lng
        }

    }

    suspend fun doAddOrSave(title: String, description: String, difficulty: String) {
        hikingtrail.title = title
        hikingtrail.description = description
        hikingtrail.difficulty = difficulty
        if (edit) {
            app.hikingtrails.update(hikingtrail)
        } else {
            app.hikingtrails.create(hikingtrail)
        }

        view.finish()

    }

    fun doCancel() {
        view.finish()

    }

    suspend fun doDelete() {
        app.hikingtrails.delete(hikingtrail)
        view.finish()

    }

    fun doSelectImage() {
        showImagePicker(imageIntentLauncher)
    }

    fun doSetLocation() {
        locationManualyChanged = true;

        if (hikingtrail.location.zoom != 0f) {

            location.lat =  hikingtrail.location.lat
            location.lng = hikingtrail.location.lng
            location.zoom = hikingtrail.location.zoom
            locationUpdate(hikingtrail.location.lat, hikingtrail.location.lng)
        }
        val launcherIntent = Intent(view, EditLocationView::class.java)
            .putExtra("location", location)
        mapIntentLauncher.launch(launcherIntent)
    }

    @SuppressLint("MissingPermission")
    fun doSetCurrentLocation() {

        locationService.lastLocation.addOnSuccessListener {
            locationUpdate(it.latitude, it.longitude)
        }
    }

    @SuppressLint("MissingPermission")
    fun doRestartLocationUpdates() {
        var locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                if (locationResult != null && locationResult.locations != null) {
                    val l = locationResult.locations.last()
                    if(!locationManualyChanged){
                        locationUpdate(l.latitude, l.longitude)
                    }
                }
            }
        }
        if (!edit) {
            locationService.requestLocationUpdates(locationRequest, locationCallback, null)
        }
    }
    fun doConfigureMap(m: GoogleMap) {
        map = m
        locationUpdate(hikingtrail.location.lat, hikingtrail.location.lng)
    }

    fun locationUpdate(lat: Double, lng: Double) {
        hikingtrail.location = location
        map?.clear()
        map?.uiSettings?.setZoomControlsEnabled(true)
        val options = MarkerOptions().title(hikingtrail.title).position(LatLng(hikingtrail.location.lat, hikingtrail.location.lng))
        map?.addMarker(options)
        map?.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(hikingtrail.location.lat, hikingtrail.location.lng), hikingtrail.location.zoom))
        view.showHikingtrail(hikingtrail)
    }

    fun cacheHikingtrail (title: String, description: String, difficulty: String) {
        hikingtrail.title = title;
        hikingtrail.description = description
        hikingtrail.difficulty = difficulty
    }

    private fun registerImagePickerCallback() {

        imageIntentLauncher =
            view.registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { result ->
                when(result.resultCode){
                    AppCompatActivity.RESULT_OK -> {
                        if (result.data != null) {
                            Timber.i("Got Result ${result.data!!.data}")
                            hikingtrail.image = result.data!!.data!!.toString()
                            view.updateImage(hikingtrail.image)
                        }
                    }
                    AppCompatActivity.RESULT_CANCELED -> { } else -> { }
                }

            }
    }

    private fun registerMapCallback() {
        mapIntentLauncher =
            view.registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { result ->
                when (result.resultCode) {
                    AppCompatActivity.RESULT_OK -> {
                        if (result.data != null) {
                            Timber.i("Got Location ${result.data.toString()}")
                            val location = result.data!!.extras?.getParcelable<Location>("location")!!
                            Timber.i("Location == $location")
                            hikingtrail.location = location
                        } // end of if
                    }
                    AppCompatActivity.RESULT_CANCELED -> { } else -> { }
                }

            }
    }

    private fun doPermissionLauncher() {
        i("permission check called")
        requestPermissionLauncher =
            view.registerForActivityResult(ActivityResultContracts.RequestPermission())
            { isGranted: Boolean ->
                if (isGranted) {
                    doSetCurrentLocation()
                } else {
                    locationUpdate(location.lat, location.lng)
                }
            }
    }
}