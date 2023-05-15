package com.kosach.dictionary.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kosach.dictionary.repository.dao.WordDao
import com.kosach.dictionary.repository.model.WordEntity

@Database(entities = [WordEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "dictionary-database"
    }

    abstract fun workDao(): WordDao

}