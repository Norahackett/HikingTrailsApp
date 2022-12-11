package org.wit.hikingtrail.main

import android.app.Application
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import org.wit.hikingtrail.R
import org.wit.hikingtrail.databinding.HomeBinding
import org.wit.hikingtrail.models.*
import org.wit.hikingtrail.room.HikingtrailStoreRoom
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    lateinit var hikingtrails: HikingtrailStore


    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        hikingtrails = HikingtrailFireStore(applicationContext)
        i("Hikingtrail started")
    }


}
