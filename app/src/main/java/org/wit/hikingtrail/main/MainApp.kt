package org.wit.hikingtrail.main

import android.app.Application
import org.wit.hikingtrail.models.HikingtrailMemStore
//import org.wit.hikingtrail.models.HikingtrailModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    //val hikingtrails = ArrayList<HikingtrailModel>()
    val hikingtrails = HikingtrailMemStore()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("HikingTrail started")

    }
}