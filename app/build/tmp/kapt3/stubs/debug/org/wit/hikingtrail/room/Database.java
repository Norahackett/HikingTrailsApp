package org.wit.hikingtrail.room;

import java.lang.System;

@androidx.room.TypeConverters(value = {org.wit.hikingtrail.helpers.Converters.class})
@androidx.room.Database(entities = {org.wit.hikingtrail.models.HikingtrailModel.class}, version = 2, exportSchema = false)
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lorg/wit/hikingtrail/room/Database;", "Landroidx/room/RoomDatabase;", "()V", "hikingtrailDao", "Lorg/wit/hikingtrail/room/HikingtrailDao;", "app_debug"})
public abstract class Database extends androidx.room.RoomDatabase {
    
    public Database() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract org.wit.hikingtrail.room.HikingtrailDao hikingtrailDao();
}