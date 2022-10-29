package org.wit.hikingtrail.activities

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.media.Rating
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import org.wit.hikingtrail.R
import org.wit.hikingtrail.databinding.ActivityHikingtrailBinding
import org.wit.hikingtrail.main.MainApp
import org.wit.hikingtrail.models.Location
import org.wit.hikingtrail.models.HikingtrailModel
import org.wit.hikingtrail.helpers.showImagePicker
import timber.log.Timber.i


class HikingtrailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHikingtrailBinding
    var hikingtrail = HikingtrailModel()
    lateinit var app: MainApp
    private lateinit var imageIntentLauncher: ActivityResultLauncher<Intent>
    private lateinit var mapIntentLauncher: ActivityResultLauncher<Intent>


    //var location = Location(52.245696, -7.139102, 15f)
    var edit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityHikingtrailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)


        app = application as MainApp

        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val today = Calendar.getInstance()
        datePicker.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            val month = month + 1
            binding.dateView.setText("$day/$month/$year")
            val msg = "You Selected: $day/$month/$year"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        i("Hikingtrail Activity started...")

        if (intent.hasExtra("hikingtrail_edit")) {
            edit = true

            hikingtrail = intent.extras?.getParcelable("hikingtrail_edit")!!
            binding.hikingtrailTitle.setText(hikingtrail.title)
            binding.description.setText(hikingtrail.description)
            binding.county.setText(hikingtrail.county)
            binding.rating.setText(hikingtrail.rating)
            binding.difficulty.setText(hikingtrail.difficulty)
            binding.dateView.setText(hikingtrail.date)


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
            hikingtrail.county = binding.county.text.toString()
            hikingtrail.difficulty = binding.difficulty.text.toString()
            hikingtrail.rating = binding.rBar.rating.toString()
            hikingtrail.date = binding.dateView.text.toString()


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


            val difficulty = resources.getStringArray(R.array.Difficulty)
            val county = resources.getStringArray(R.array.County)
            if (binding.spinner2 != null) {
                val adapter2 = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item, county

                )

                binding.spinner2.adapter = adapter2


                binding.spinner2.onItemSelectedListener = object :

                    AdapterView.OnItemSelectedListener {

                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View, position: Int, id: Long

                    ) {

                        binding.county.setText(county[position])

                        if (county != null) {
                            val spinnerPosition2 = adapter2.getPosition(county.toString())
                            binding.spinner.setSelection(spinnerPosition2)
                        }

                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {

                    }
                }
            }


        //val difficulty = resources.getStringArray(R.array.Difficulty)
        if (binding.spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, difficulty

            )

            binding.spinner.adapter = adapter


            binding.spinner.onItemSelectedListener = object :

                AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long

                ) {

                    binding.difficulty.setText(difficulty[position])

                    if (difficulty != null) {
                        val spinnerPosition = adapter.getPosition(difficulty.toString())
                        binding.spinner.setSelection(spinnerPosition)
                    }

                }

                override fun onNothingSelected(parent: AdapterView<*>) {

                }
            }
        }


        binding.chooseImage.setOnClickListener {
            showImagePicker(imageIntentLauncher)
        }

        binding.hikingtrailLocation.setOnClickListener {
            val location = Location(53.245696, -6.139102, 15f)
            if (hikingtrail.zoom != 0f) {
                location.lat = hikingtrail.lat
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
        if (edit) menu.getItem(0).isVisible = true
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_delete -> {
                app.hikingtrails.delete(hikingtrail)
                finish()
            }
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
                            binding.chooseImage.setText(R.string.change_hikingtrail_image)
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
                            val location =
                                result.data!!.extras?.getParcelable<Location>("location")!!
                            i("Location == $location")
                            hikingtrail.lat = location.lat
                            hikingtrail.lng = location.lng
                            hikingtrail.zoom = location.zoom
                        } // end of if
                    }
                    RESULT_CANCELED -> {}
                    else -> {}
                }
            }
    }
}

