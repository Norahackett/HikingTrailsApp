package org.wit.hikingtrail.room


import androidx.room.*
import org.wit.hikingtrail.models.HikingtrailModel

@Dao
interface HikingtrailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(hikingtrail: HikingtrailModel)

    @Query("SELECT * FROM HikingtrailModel")
    suspend fun findAll(): List<HikingtrailModel>

    @Query("select * from HikingtrailModel where id = :id")
    suspend fun findById(id: Long): HikingtrailModel

    @Update
    suspend fun update(hikingtrail: HikingtrailModel)

    @Delete
    suspend fun deleteHikingtrail(hikingtrail: HikingtrailModel)
}