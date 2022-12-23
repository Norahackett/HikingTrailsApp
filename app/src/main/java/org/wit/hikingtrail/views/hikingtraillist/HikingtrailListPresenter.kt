package org.wit.hikingtrail.views.hikingtraillist

import android.content.Intent
import android.provider.Settings.Global.getString
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.wit.hikingtrail.R
import org.wit.hikingtrail.main.MainApp
import org.wit.hikingtrail.models.HikingtrailModel
import org.wit.hikingtrail.views.about.AboutView
import org.wit.hikingtrail.views.login.LoginView
import org.wit.hikingtrail.views.hikingtrail.HikingtrailView
import org.wit.hikingtrail.views.map.HikingtrailMapView

class HikingtrailListPresenter(private val view: HikingtrailListView) {

    var app: MainApp = view.application as MainApp
    private lateinit var refreshIntentLauncher: ActivityResultLauncher<Intent>
    private lateinit var editIntentLauncher: ActivityResultLauncher<Intent>

    init {
        registerEditCallback()
        registerRefreshCallback()
    }

    suspend fun getHikingtrails() = app.hikingtrails.findAll()

    fun doAddHikingtrail() {
        val launcherIntent = Intent(view, HikingtrailView::class.java)
        editIntentLauncher.launch(launcherIntent)
    }

    fun doShowAbout() {
        val launcherIntent = Intent(view, AboutView::class.java)
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

    suspend fun doLogout() {
        FirebaseAuth.getInstance().signOut()
        app.hikingtrails.clear()
        val launcherIntent = Intent(view, LoginView::class.java)
        editIntentLauncher.launch(launcherIntent)
    }

    private fun registerRefreshCallback() {
        refreshIntentLauncher =
            view.registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            {
                GlobalScope.launch(Dispatchers.Main) {
                    getHikingtrails()
                }
            }
    }

    private fun registerEditCallback() {
        editIntentLauncher =
            view.registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { }

    }



}
