package org.wit.hikingtrail.views.hikingtrail


import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.gms.maps.GoogleMap
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.wit.hikingtrail.R
import org.wit.hikingtrail.databinding.ActivityHikingtrailBinding
import org.wit.hikingtrail.models.Location
import org.wit.hikingtrail.models.HikingtrailModel
import timber.log.Timber.i


class HikingtrailView : AppCompatActivity() {

    private lateinit var binding: ActivityHikingtrailBinding
    private lateinit var presenter: HikingtrailPresenter
    lateinit var map: GoogleMap
    var hikingtrail = HikingtrailModel()
    lateinit var hikeDifficulty: RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val difficulty = resources.getStringArray(R.array.Difficulty)
        binding = ActivityHikingtrailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)

        presenter = HikingtrailPresenter(this)

        hikeDifficulty = findViewById(R.id.hikeDifficulty)

        hikeDifficulty.setOnCheckedChangeListener { group, checkedId ->

            // on below line we are getting radio button from our group.
            val radioButton = findViewById<RadioButton>(checkedId)

            // on below line we are displaying a toast message.
            Toast.makeText(
                this@HikingtrailView,
                "Selected Radio Button is : " + radioButton.text,
                Toast.LENGTH_SHORT
            ).show()
        }





        binding.chooseImage.setOnClickListener {
            presenter.cacheHikingtrail(binding.hikingtrailTitle.text.toString(), binding.description.text.toString(), binding.difficulty.text.toString(), binding.rating.text.toString())
            presenter.doSelectImage()
        }

        binding.mapView2.setOnClickListener {
            presenter.cacheHikingtrail(binding.hikingtrailTitle.text.toString(), binding.description.text.toString(), binding.difficulty.text.toString(), binding.rating.text.toString())
            presenter.doSetLocation()
        }

        binding.mapView2.onCreate(savedInstanceState);
        binding.mapView2.getMapAsync {
            map = it
            presenter.doConfigureMap(map)
            it.setOnMapClickListener { presenter.doSetLocation() }
        }

        if (binding.spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, difficulty

            )
            //binding.spinner.adapter = adapter


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
    }




    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_hikingtrail, menu)
        val deleteMenu: MenuItem = menu.findItem(R.id.item_delete)
        if (presenter.edit){
            deleteMenu.setVisible(true)
        }
        else{
            deleteMenu.setVisible(false)
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_save -> {
                if (binding.hikingtrailTitle.text.toString().isEmpty()) {
                    Snackbar.make(binding.root, R.string.enter_hikingtrail_title, Snackbar.LENGTH_LONG)
                        .show()
                } else {
                    GlobalScope.launch(Dispatchers.IO) {
                        presenter.doAddOrSave(
                            binding.hikingtrailTitle.text.toString(),
                            binding.description.text.toString(),
                            binding.difficulty.text.toString(),
                            binding.rBar.rating.toString(),
                        )
                    }
                }
            }
            R.id.item_delete -> {
                GlobalScope.launch(Dispatchers.IO){
                    presenter.doDelete()
                }
            }
            R.id.item_cancel -> {
                presenter.doCancel()
            }

        }
        return super.onOptionsItemSelected(item)
    }

    fun showHikingtrail(hikingtrail: HikingtrailModel) {
        if (binding.hikingtrailTitle.text.isEmpty()) binding.hikingtrailTitle.setText(hikingtrail.title)
        if (binding.description.text.isEmpty())  binding.description.setText(hikingtrail.description)
        if (binding.difficulty.text.isEmpty())  binding.difficulty.setText(hikingtrail.difficulty)
        if (binding.rating.text.isEmpty())  binding.rating.setText(hikingtrail.rating)
        if (hikingtrail.image != "") {
            Picasso.get()
                .load(hikingtrail.image)
                .into(binding.hikingtrailImage)

            binding.chooseImage.setText(R.string.change_hikingtrail_image)
        }
        this.showLocation(hikingtrail.location)
    }
    private fun showLocation (loc: Location){
        binding.lat.setText("%.6f".format(loc.lat))
        binding.lng.setText("%.6f".format(loc.lng))
    }

    fun updateImage(image: String){
        i("Image updated")
        Picasso.get()
            .load(image)
            .into(binding.hikingtrailImage)
        binding.chooseImage.setText(R.string.change_hikingtrail_image)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.mapView2.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView2.onLowMemory()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView2.onPause()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView2.onResume()
        presenter.doRestartLocationUpdates()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView2.onSaveInstanceState(outState)
    }



}
