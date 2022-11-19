package org.wit.hikingtrail.views.hikingtrail

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import org.wit.hikingtrail.R
import org.wit.hikingtrail.databinding.ActivityHikingtrailBinding
import org.wit.hikingtrail.models.HikingtrailModel
import timber.log.Timber.i

class HikingtrailView : AppCompatActivity() {

    private lateinit var binding: ActivityHikingtrailBinding
    lateinit var presenter: HikingtrailPresenter
    var hikingtrail = HikingtrailModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHikingtrailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)

        presenter = HikingtrailPresenter(this)

        binding.btnAdd.setOnClickListener() {
            hikingtrail.title = binding.hikingtrailTitle.text.toString()
            hikingtrail.description = binding.description.text.toString()
            if (hikingtrail.title.isEmpty()) {
                Snackbar.make(it, R.string.enter_hikingtrail_title, Snackbar.LENGTH_LONG)
                    .show()
            } else {
                presenter.doAddOrSave(hikingtrail.title, hikingtrail.description)

            }
            i("add Button Pressed: $hikingtrail")
            setResult(RESULT_OK)
            finish()
        }

        binding.chooseImage.setOnClickListener {
            presenter.doSelectImage()
        }

        binding.hikingtrailLocation.setOnClickListener {
            presenter.doSetLocation()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_hikingtrail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_cancel -> {
                presenter.doCancel()
            }

        }
        return super.onOptionsItemSelected(item)
    }

    fun showHikingtrail(hikingtrail: HikingtrailModel) {
        binding.hikingtrailTitle.setText(hikingtrail.title)
        binding.description.setText(hikingtrail.description)
        binding.btnAdd.setText(R.string.save_hikingtrail)
        Picasso.get()
            .load(hikingtrail.image)
            .into(binding.hikingtrailImage)
        if (hikingtrail.image != Uri.EMPTY) {
            binding.chooseImage.setText(R.string.change_hikingtrail_image)
        }
        binding.btnAdd.setText(R.string.save_hikingtrail)
    }
}

