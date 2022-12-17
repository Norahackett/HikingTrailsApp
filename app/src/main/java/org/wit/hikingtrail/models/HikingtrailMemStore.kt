package org.wit.hikingtrail.models



import timber.log.Timber.i

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class HikingtrailMemStore : HikingtrailStore {

    val hikingtrails = ArrayList<HikingtrailModel>()

    override suspend fun findAll(): List<HikingtrailModel> {
        return hikingtrails
    }

    override suspend fun create(hikingtrail: HikingtrailModel) {
        hikingtrail.id = getId()
        hikingtrails.add(hikingtrail)
        logAll()
    }

    override suspend fun update(hikingtrail: HikingtrailModel) {
        val foundHikingtrail: HikingtrailModel? = hikingtrails.find { t -> t.id == hikingtrail.id }
        if (foundHikingtrail != null) {
            foundHikingtrail.title = hikingtrail.title
            foundHikingtrail.description = hikingtrail.description
            foundHikingtrail.difficulty = hikingtrail.difficulty
            foundHikingtrail.image = hikingtrail.image
            foundHikingtrail.location = hikingtrail.location
            logAll()
        }
    }

    override suspend fun delete(hikingtrail: HikingtrailModel) {
        hikingtrails.remove(hikingtrail)
        logAll()
    }

    private fun logAll() {
        hikingtrails.forEach { i("$it") }
    }

    override suspend fun findById(id: Long): HikingtrailModel? {
        val foundHikingtrail: HikingtrailModel? = hikingtrails.find { it.id == id }
        return foundHikingtrail
    }

    override suspend fun clear() {
        hikingtrails.clear()
    }
}