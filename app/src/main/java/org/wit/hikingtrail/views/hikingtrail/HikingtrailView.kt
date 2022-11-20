package org.wit.hikingtrail.views.hikingtrail

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.gms.maps.GoogleMap
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import org.wit.hikingtrail.R
import org.wit.hikingtrail.databinding.ActivityHikingtrailBinding
import org.wit.hikingtrail.models.HikingtrailModel
import timber.log.Timber.i

class HikingtrailView : AppCompatActivity() {

    private lateinit var binding: ActivityHikingtrailBinding
    private lateinit var presenter: HikingtrailPresenter
    lateinit var map: GoogleMap
    var hikingtrail = HikingtrailModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHikingtrailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)

        presenter = HikingtrailPresenter(this)

        binding.chooseImage.setOnClickListener {
            presenter.cacheHikingtrail(binding.hikingtrailTitle.text.toString(), binding.description.text.toString())
            presenter.doSelectImage()
        }

        binding.hikingtrailLocation.setOnClickListener {
            presenter.cacheHikingtrail(binding.hikingtrailTitle.text.toString(), binding.description.text.toString())
            presenter.doSetLocation()
        }

        binding.mapView2.onCreate(savedInstanceState);
        binding.mapView2.getMapAsync {
            map = it
            presenter.doConfigureMap(map)
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
                    presenter.doAddOrSave(binding.hikingtrailTitle.text.toString(), binding.description.text.toString())
                }
            }
            R.id.item_delete -> {
                presenter.doDelete()
            }
            R.id.item_cancel -> {
                presenter.doCancel()
            }

        }
        return super.onOptionsItemSelected(item)
    }
    fun showHikingtrail(hikingtrail: HikingtrailModel) {
        binding.hikingtrailTitle.setText(hikingtrail.title)
        binding.description.setText(hikingtrail.description)

        Picasso.get()
            .load(hikingtrail.image)
            .into(binding.hikingtrailImage)
        if (hikingtrail.image != Uri.EMPTY) {
            binding.chooseImage.setText(R.string.change_hikingtrail_image)
        }

    }

    fun updateImage(image: Uri){
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
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView2.onSaveInstanceState(outState)
    }

}