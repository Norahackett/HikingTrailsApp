package org.wit.hikingtrail.views.hikingtraillist

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import org.wit.hikingtrail.models.HikingtrailModel
import org.wit.hikingtrail.views.hikingtrail.HikingtrailView
import org.wit.hikingtrail.main.MainApp
import org.wit.hikingtrail.views.map.HikingtrailMapView

class HikingtrailListPresenter(val view: HikingtrailListView) {

    var app: MainApp = view.application as MainApp
    private lateinit var refreshIntentLauncher : ActivityResultLauncher<Intent>
    private lateinit var editIntentLauncher : ActivityResultLauncher<Intent>
    private lateinit var mapIntentLauncher : ActivityResultLauncher<Intent>

    init {
        registerEditCallback()
        registerRefreshCallback()
    }

    fun getHikingtrails() = app.hikingtrails.findAll()

    fun doAddHikingtrail() {
        val launcherIntent = Intent(view, HikingtrailView::class.java)
        editIntentLauncher.launch(launcherIntent)
    }

    fun doEditHikingtrail(hikingtrail: HikingtrailModel) {
        val launcherIntent = Intent(view, HikingtrailView::class.java)
        launcherIntent.putExtra("hikingtrail_edit", hikingtrail)
        editIntentLauncher.launch(launcherIntent)
    }

    fun doShowHikingtrailsMap() {
        val launcherIntent = Intent(view, HikingtrailMapView::class.java)
        editIntentLauncher.launch(launcherIntent)
    }
    private fun registerRefreshCallback() {
        refreshIntentLauncher =
            view.registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { getHikingtrails() }
    }
    private fun registerEditCallback() {
        editIntentLauncher =
            view.registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            {  }

    }
}