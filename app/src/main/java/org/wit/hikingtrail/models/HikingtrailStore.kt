package org.wit.hikingtrail.models

interface HikingtrailStore {
    suspend fun findAll(): List<HikingtrailModel>
    suspend fun create(hikingtrail: HikingtrailModel)
    suspend fun update(hikingtrail: HikingtrailModel)
    suspend fun findById(id:Long) : HikingtrailModel?
    suspend fun delete(hikingtrail: HikingtrailModel)
    suspend fun clear()
}