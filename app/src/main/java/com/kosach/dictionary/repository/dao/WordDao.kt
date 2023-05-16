package com.kosach.dictionary.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kosach.dictionary.repository.model.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Insert
    suspend fun insert(wordEntity: WordEntity): Long

    @Query("SELECT * FROM WordTable")
    fun getAllList(): Flow<List<WordEntity>>

}