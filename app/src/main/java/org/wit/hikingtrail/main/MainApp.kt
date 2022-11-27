package org.wit.hikingtrail.main

import android.app.Application
import org.wit.hikingtrail.models.*
import org.wit.hikingtrail.room.HikingtrailStoreRoom
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    lateinit var hikingtrails: HikingtrailStore

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        hikingtrails = HikingtrailStoreRoom(applicationContext)
        i("Hikingtrail started")
    }
}