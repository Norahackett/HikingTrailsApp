package org.wit.hikingtrail.models

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
        val foundHikingtrail: HikingtrailModel? = hikingtrails.find { p -> p.id == hikingtrail.id }
        if (foundHikingtrail != null) {
            foundHikingtrail.title = hikingtrail.title
            foundHikingtrail.description = hikingtrail.description
            foundHikingtrail.image = hikingtrail.image
            foundHikingtrail.lat = hikingtrail.lat
            foundHikingtrail.lng = hikingtrail.lng
            foundHikingtrail.zoom = hikingtrail.zoom
            logAll()
        }
    }
    override fun delete(hikingtrail: HikingtrailModel) {
        hikingtrails.remove(hikingtrail)
        logAll()
    }

    private fun logAll() {
        hikingtrails.forEach { i("$it") }
    }
    override fun findById(id:Long) : HikingtrailModel? {
        val foundHikingtrail: HikingtrailModel? = hikingtrails.find { it.id == id }
        return foundHikingtrail
    }
}