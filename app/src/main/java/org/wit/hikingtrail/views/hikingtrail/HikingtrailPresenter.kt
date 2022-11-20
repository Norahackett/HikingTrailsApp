package org.wit.hikingtrail.views.hikingtrail

import android.annotation.SuppressLint
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.wit.hikingtrail.helpers.checkLocationPermissions
import org.wit.hikingtrail.main.MainApp
import org.wit.hikingtrail.models.Location
import org.wit.hikingtrail.models.HikingtrailModel
import org.wit.hikingtrail.showImagePicker
import org.wit.hikingtrail.views.location.EditLocationView
import timber.log.Timber
import timber.log.Timber.i

class HikingtrailPresenter(private val view: HikingtrailView) {
    var map: GoogleMap? = null
    var hikingtrail = HikingtrailModel()
    var app: MainApp = view.application as MainApp
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
            hikingtrail.lat = location.lat
            hikingtrail.lng = location.lng
        }

    }


    fun doAddOrSave(title: String, description: String) {
        hikingtrail.title = title
        hikingtrail.description = description
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

    fun doDelete() {
        app.hikingtrails.delete(hikingtrail)
        view.finish()

    }

    fun doSelectImage() {
        showImagePicker(imageIntentLauncher)
    }

    fun doSetLocation() {

        if (hikingtrail.zoom != 0f) {
            location.lat =  hikingtrail.lat
            location.lng = hikingtrail.lng
            location.zoom = hikingtrail.zoom
            locationUpdate(hikingtrail.lat, hikingtrail.lng)
        }
        val launcherIntent = Intent(view, EditLocationView::class.java)
            .putExtra("location", location)
        mapIntentLauncher.launch(launcherIntent)
    }

    @SuppressLint("MissingPermission")
    fun doSetCurrentLocation() {
        i("setting location from doSetLocation")
        locationService.lastLocation.addOnSuccessListener {
            locationUpdate(it.latitude, it.longitude)
        }
    }

    fun cacheHikingtrail (title: String, description: String) {
        hikingtrail.title = title;
        hikingtrail.description = description
    }
    fun doConfigureMap(m: GoogleMap) {
        map = m
        locationUpdate(hikingtrail.lat, hikingtrail.lng)
    }

    fun locationUpdate(lat: Double, lng: Double) {
        hikingtrail.lat = lat
        hikingtrail.lng = lng
        hikingtrail.zoom = 15f
        map?.clear()
        map?.uiSettings?.setZoomControlsEnabled(true)
        val options = MarkerOptions().title(hikingtrail.title).position(LatLng(hikingtrail.lat, hikingtrail.lng))
        map?.addMarker(options)
        map?.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(hikingtrail.lat, hikingtrail.lng), hikingtrail.zoom))
        view.showHikingtrail(hikingtrail)
    }



    private fun registerImagePickerCallback() {

        imageIntentLauncher =
            view.registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { result ->
                when(result.resultCode){
                    AppCompatActivity.RESULT_OK -> {
                        if (result.data != null) {
                            Timber.i("Got Result ${result.data!!.data}")
                            hikingtrail.image = result.data!!.data!!
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
                            hikingtrail.lat = location.lat
                            hikingtrail.lng = location.lng
                            hikingtrail.zoom = location.zoom
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

