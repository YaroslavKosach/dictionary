package com.kosach.dictionary.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.DeleteColumn
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kosach.dictionary.repository.dao.WordDao
import com.kosach.dictionary.repository.model.WordEntity

@Database(
    entities = [WordEntity::class],
    version = 7,
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

val MIGRATION_3_4 = object : Migration(3, 4) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE wordtable ADD COLUMN test_min_long INTEGER DEFAULT 0")
    }
}

val MIGRATION_4_5 = object : Migration(4, 5) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE WordTableNew(id INTEGER PRIMARY KEY, english_value TEXT NOT NULL, ukraine_value TEXT NOT NULL, description TEXT);")
        database.execSQL("INSERT INTO WordTableNew SELECT id, english_value, ukraine_value, description FROM WordTable")
        database.execSQL("DROP TABLE WordTable")
        database.execSQL("ALTER TABLE WordTableNew RENAME TO WordTable")
    }
}


val MIGRATION_5_6 = object : Migration(5,6) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE wordtable ADD COLUMN test_min_long INTEGER DEFAULT 0")
    }
}

val MIGRATION_6_7 = object : Migration(6,7) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE WordTableNew(id INTEGER PRIMARY KEY, english_value TEXT NOT NULL, ukraine_value TEXT NOT NULL, description TEXT);")
        database.execSQL("INSERT INTO WordTableNew SELECT id, english_value, ukraine_value, description FROM WordTable")
        database.execSQL("DROP TABLE WordTable")
        database.execSQL("ALTER TABLE WordTableNew RENAME TO WordTable")
    }
}