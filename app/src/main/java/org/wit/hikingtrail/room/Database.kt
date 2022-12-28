package org.wit.hikingtrail.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.wit.hikingtrail.helpers.Converters
import org.wit.hikingtrail.models.HikingtrailModel

@Database(entities = [HikingtrailModel::class], version = 3,  exportSchema = false)
@TypeConverters(Converters::class)
abstract class Database : RoomDatabase() {
    abstract fun hikingtrailDao(): HikingtrailDao
}