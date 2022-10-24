package org.wit.hikingtrail.models

interface HikingtrailStore {
    fun findAll(): List<HikingtrailModel>
    fun create(hikingtrail: HikingtrailModel)
    fun update(hikingtrail: HikingtrailModel)
    fun delete(hikingtrail: HikingtrailModel)
}