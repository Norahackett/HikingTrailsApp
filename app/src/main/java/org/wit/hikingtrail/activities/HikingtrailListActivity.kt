package org.wit.hikingtrail.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.wit.hikingtrail.R
import org.wit.hikingtrail.adapters.HikingtrailAdapter
import org.wit.hikingtrail.adapters.HikingtrailListener
import org.wit.hikingtrail.databinding.ActivityHikingtrailListBinding
import org.wit.hikingtrail.main.MainApp
import org.wit.hikingtrail.models.HikingtrailModel

class HikingtrailListActivity : AppCompatActivity(), HikingtrailListener/*, MultiplePermissionsListener*/ {

    lateinit var app: MainApp
    var hikingtrail = HikingtrailModel()
    private lateinit var binding: ActivityHikingtrailListBinding
    private lateinit var refreshIntentLauncher: ActivityResultLauncher<Intent>
    private lateinit var mapIntentLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHikingtrailListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        loadHikingtrails()
        registerRefreshCallback()
        registerMapCallback()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                val launcherIntent = Intent(this, HikingtrailActivity::class.java)
                refreshIntentLauncher.launch(launcherIntent)
            }
            R.id.item_map -> {
                val launcherIntent = Intent(this, HikingtrailMapsActivity::class.java)
                mapIntentLauncher.launch(launcherIntent)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onHikingtrailClick(hikingtrail: HikingtrailModel) {
        val launcherIntent = Intent(this, HikingtrailActivity::class.java)
        launcherIntent.putExtra("hikingtrail_edit", hikingtrail)
        refreshIntentLauncher.launch(launcherIntent)
    }

    private fun registerRefreshCallback() {
        refreshIntentLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { loadHikingtrails() }
    }

    private fun registerMapCallback() {
        mapIntentLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { }
    }

    private fun loadHikingtrails() {
        showHikingtrails(app.hikingtrails.findAll())
    }

    fun showHikingtrails(hikingtrails: List<HikingtrailModel>) {
        binding.recyclerView.adapter = HikingtrailAdapter(hikingtrails, this)
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }



}