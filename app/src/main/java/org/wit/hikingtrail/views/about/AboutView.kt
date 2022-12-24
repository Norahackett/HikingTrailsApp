package org.wit.hikingtrail.views.about


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import org.wit.hikingtrail.R
import org.wit.hikingtrail.databinding.ActivityAboutBinding
import org.wit.hikingtrail.main.MainApp


class AboutView : AppCompatActivity() {
    lateinit var app: MainApp
    lateinit var binding: ActivityAboutBinding
    lateinit var presenter: AboutPresenter



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarAdd)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_back, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.back -> {
                presenter.doCancel()
            }

        }
        return super.onOptionsItemSelected(item)
    }
}