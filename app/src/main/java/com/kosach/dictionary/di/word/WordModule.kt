package com.kosach.dictionary.di.word

import com.kosach.dictionary.database.AppDatabase
import com.kosach.dictionary.repository.WordRepository
import com.kosach.dictionary.repository.WordRepositoryImp
import com.kosach.dictionary.repository.dao.WordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordModule {

    @Singleton
    @Provides
    fun provideWordDao(appDatabase: AppDatabase): WordDao {
        return appDatabase.workDao()
    }

    @Singleton
    @Provides
    fun provideWordRepository(dao: WordDao): WordRepository {
        return WordRepositoryImp(dao)
    }

}