package org.wit.placemark.views.hikingtraillist

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import org.wit.hikingtrail.activities.HikingtrailMapsActivity
import org.wit.hikingtrail.main.MainApp
import org.wit.hikingtrail.models.HikingtrailModel
import org.wit.hikingtrail.views.hikingtrail.HikingtrailView
import org.wit.hikingtrail.views.hikingtraillist.HikingtrailListView

class HikingtrailListPresenter(val view: HikingtrailListView) {

    var app: MainApp
    private lateinit var refreshIntentLauncher : ActivityResultLauncher<Intent>
    private lateinit var mapIntentLauncher : ActivityResultLauncher<Intent>

    init {
        app = view.application as MainApp
        registerMapCallback()
        registerRefreshCallback()
    }

    fun getHikingtrails() = app.hikingtrails.findAll()

    fun doAddHikingtrail() {
        val launcherIntent = Intent(view, HikingtrailView::class.java)
        refreshIntentLauncher.launch(launcherIntent)
    }

    fun doEditHikingtrail(hikingtrail: HikingtrailModel) {
        val launcherIntent = Intent(view, HikingtrailView::class.java)
        launcherIntent.putExtra("hikingtrail_edit", hikingtrail)
        mapIntentLauncher.launch(launcherIntent)
    }

    fun doShowHikingtrailsMap() {
        val launcherIntent = Intent(view, HikingtrailMapsActivity::class.java)
        refreshIntentLauncher.launch(launcherIntent)
    }
    private fun registerRefreshCallback() {
        refreshIntentLauncher =
            view.registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { getHikingtrails() }
    }
    private fun registerMapCallback() {
        mapIntentLauncher =
            view.registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            {  }
    }
}