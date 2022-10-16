package org.wit.hikingtrail.models

import org.wit.hikingtrail.models.HikingtrailModel
import org.wit.hikingtrail.models.HikingtrailStore
import timber.log.Timber.i

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class HikingtrailMemStore : HikingtrailStore {

    val hikingtrails = ArrayList<HikingtrailModel>()

    override fun findAll(): List<HikingtrailModel> {
        return hikingtrails
    }

    override fun create(hikingtrail: HikingtrailModel) {
        hikingtrail.id = getId()
        hikingtrails.add(hikingtrail)
        logAll()
    }

    override fun update(hikingtrail: HikingtrailModel) {
        var foundHikingtrail: HikingtrailModel? = hikingtrails.find { p -> p.id == hikingtrail.id }
        if (foundHikingtrail != null) {
            foundHikingtrail.title = hikingtrail.title
            foundHikingtrail.description = hikingtrail.description
            logAll()
        }
    }
    private fun logAll() {
        hikingtrails.forEach { i("$it") }
    }
}
