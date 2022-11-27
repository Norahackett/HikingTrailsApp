package org.wit.hikingtrail.room


import android.content.Context
import androidx.room.Room
import org.wit.hikingtrail.models.HikingtrailModel
import org.wit.hikingtrail.models.HikingtrailStore

class HikingtrailStoreRoom(val context: Context) : HikingtrailStore {

    var dao: HikingtrailDao

    init {
        val database = Room.databaseBuilder(context, Database::class.java, "room_sample.db")
            .fallbackToDestructiveMigration()
            .build()
        dao = database.hikingtrailDao()
    }

    override suspend fun findAll(): List<HikingtrailModel> {

        return dao.findAll()
    }

    override suspend fun findById(id: Long): HikingtrailModel? {
        return dao.findById(id)
    }

    override suspend fun create(hikingtrail: HikingtrailModel) {
        dao.create(hikingtrail)
    }

    override suspend fun update(hikingtrail: HikingtrailModel) {
        dao.update(hikingtrail)
    }

    override suspend fun delete(hikingtrail: HikingtrailModel) {
        dao.deleteHikingtrail(hikingtrail)
    }

    override suspend fun clear() {
        TODO("Not yet implemented")
    }
}