package com.kosach.dictionary.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import com.kosach.dictionary.repository.model.WordEntity

@Dao
interface WordDao {

    @Insert
    suspend fun insert(wordEntity: WordEntity): Long

}