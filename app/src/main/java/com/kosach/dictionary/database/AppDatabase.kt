package com.kosach.dictionary.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.DeleteColumn
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.AutoMigrationSpec
import com.kosach.dictionary.repository.dao.WordDao
import com.kosach.dictionary.repository.model.WordEntity

@Database(
    entities = [WordEntity::class],
    version = 3,
    autoMigrations = [
        AutoMigration (from = 1, to = 2),
        AutoMigration (from = 2, to = 3, spec = AppDatabase.MyAutoMigration::class),
    ],
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "dictionary-database"
    }

    abstract fun workDao(): WordDao


    @DeleteColumn(tableName = "WordTable", columnName = "test_min_long")
    class MyAutoMigration : AutoMigrationSpec

}