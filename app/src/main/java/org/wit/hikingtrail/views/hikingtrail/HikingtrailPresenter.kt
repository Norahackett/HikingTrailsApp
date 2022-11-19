package org.wit.hikingtrail.views.hikingtrail


import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import org.wit.hikingtrail.R
import org.wit.hikingtrail.databinding.ActivityHikingtrailBinding
import org.wit.hikingtrail.helpers.showImagePicker
import org.wit.hikingtrail.main.MainApp
import org.wit.hikingtrail.models.Location
import org.wit.hikingtrail.models.HikingtrailModel

import org.wit.hikingtrail.views.location.EditLocationView
import timber.log.Timber

class HikingtrailPresenter(val view: HikingtrailView) {

    var hikingtrail = HikingtrailModel()
    lateinit var app: MainApp
    lateinit var binding: ActivityHikingtrailBinding
    private lateinit var imageIntentLauncher : ActivityResultLauncher<Intent>
    private lateinit var mapIntentLauncher : ActivityResultLauncher<Intent>
    var edit = false;

    init {
        binding = ActivityHikingtrailBinding.inflate(view.layoutInflater)
        app = view.application as MainApp
        if (view.intent.hasExtra("hikingtrail_edit")) {
            edit = true
            hikingtrail = view.intent.extras?.getParcelable("hikingtrail_edit")!!
            view.showHikingtrail(hikingtrail)
        }
        registerImagePickerCallback()
        registerMapCallback()
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
        val location = Location(52.245696, -7.139102, 15f)
        if (hikingtrail.zoom != 0f) {
            location.lat =  hikingtrail.lat
            location.lng = hikingtrail.lng
            location.zoom = hikingtrail.zoom
        }
        val launcherIntent = Intent(view, EditLocationView::class.java)
            .putExtra("location", location)
        mapIntentLauncher.launch(launcherIntent)
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
                            Picasso.get()
                                .load(hikingtrail.image)
                                .networkPolicy(NetworkPolicy.NO_CACHE)
                                .memoryPolicy(MemoryPolicy.NO_CACHE)
                                .into(binding.hikingtrailImage)
                            binding.chooseImage.setText(R.string.change_hikingtrail_image)
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
}