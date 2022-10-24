package org.wit.hikingtrail.main

import android.app.Application
import org.wit.hikingtrail.models.HikingtrailMemStore
import org.wit.hikingtrail.models.HikingtrailStore
import org.wit.hikingtrail.models.HikingtrailJSONStore
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    //val hikingtrails = ArrayList<HikingtrailModel>()
    lateinit var  hikingtrails: HikingtrailStore

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        hikingtrails = HikingtrailJSONStore(applicationContext)
        i("HikingTrail started")

    }
}