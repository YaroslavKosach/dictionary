package com.kosach.dictionary.di.db

import android.content.Context
import androidx.room.Room
import com.kosach.dictionary.database.AppDatabase
import com.kosach.dictionary.database.MIGRATION_3_4
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        )
//            .fallbackToDestructiveMigration()
            .addMigrations(MIGRATION_3_4)
            .build()
    }

}