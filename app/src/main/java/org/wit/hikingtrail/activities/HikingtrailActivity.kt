package org.wit.hikingtrail.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import org.wit.hikingtrail.R
import org.wit.hikingtrail.databinding.ActivityHikingtrailBinding
import org.wit.hikingtrail.helpers.showImagePicker
import org.wit.hikingtrail.main.MainApp
import org.wit.hikingtrail.models.HikingtrailModel
import org.wit.hikingtrail.models.Location

import timber.log.Timber.i

class HikingtrailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHikingtrailBinding
    var hikingtrail = HikingtrailModel()
    private lateinit var imageIntentLauncher: ActivityResultLauncher<Intent>
    private lateinit var mapIntentLauncher : ActivityResultLauncher<Intent>
    lateinit var app: MainApp
    val IMAGE_REQUEST = 1
    var location = Location(52.245696, -7.139102, 15f)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var edit = false

        binding = ActivityHikingtrailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)

        app = application as MainApp

        i("Hikingtrail Activity started...")


        if (intent.hasExtra("hikingtrail_edit")) {
            edit = true
            hikingtrail = intent.extras?.getParcelable("hikingtrail_edit")!!
            binding.hikingtrailTitle.setText(hikingtrail.title)
            binding.description.setText(hikingtrail.description)
            binding.btnAdd.setText(R.string.save_hikingtrail)
            Picasso.get()
                .load(hikingtrail.image)
                .into(binding.hikingtrailImage)
            if (hikingtrail.image != Uri.EMPTY) {
                binding.chooseImage.setText(R.string.change_hikingtrail_image)
            }
        }


            binding.btnAdd.setOnClickListener() {
                hikingtrail.title = binding.hikingtrailTitle.text.toString()
                hikingtrail.description = binding.description.text.toString()
                if (hikingtrail.title.isEmpty()) {
                    Snackbar.make(it, R.string.enter_hikingtrail_title, Snackbar.LENGTH_LONG)
                        .show()
                } else {
                    if (edit) {
                        app.hikingtrails.update(hikingtrail.copy())
                    } else {
                        app.hikingtrails.create(hikingtrail.copy())
                    }
                }
                i("add Button Pressed: $hikingtrail")
                setResult(RESULT_OK)
                finish()
            }

            binding.chooseImage.setOnClickListener {
                showImagePicker(imageIntentLauncher)
            }

            binding.hikingtrailLocation.setOnClickListener {
                val location = Location(52.245696, -7.139102, 15f)
                if (hikingtrail.zoom != 0f) {
                    location.lat =  hikingtrail.lat
                    location.lng = hikingtrail.lng
                    location.zoom = hikingtrail.zoom
                }
                val launcherIntent = Intent(this, MapActivity::class.java)
                    .putExtra("location", location)
                mapIntentLauncher.launch(launcherIntent)
            }
            registerImagePickerCallback()
            registerMapCallback()

        }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_hikingtrail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun registerImagePickerCallback() {
        imageIntentLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { result ->
                when (result.resultCode) {
                    RESULT_OK -> {
                        if (result.data != null) {
                            i("Got Result ${result.data!!.data}")
                            hikingtrail.image = result.data!!.data!!
                            Picasso.get()
                                .load(hikingtrail.image)
                                .into(binding.hikingtrailImage)
                        } // end of if
                    }
                    RESULT_CANCELED -> {}
                    else -> {}
                }
            }
    }
        private fun registerMapCallback() {
            mapIntentLauncher =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult())
                { result ->
                    when (result.resultCode) {
                        RESULT_OK -> {
                            if (result.data != null) {
                                i("Got Location ${result.data.toString()}")
                                location = result.data!!.extras?.getParcelable("location")!!
                                i("Location == $location")
                                hikingtrail.lat = location.lat
                                hikingtrail.lng = location.lng
                                hikingtrail.zoom = location.zoom



                            } // end of if
                        }
                        RESULT_CANCELED -> { } else -> { }
                    }
                }
        }

}
