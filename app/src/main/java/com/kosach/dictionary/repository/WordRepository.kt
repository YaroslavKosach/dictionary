package com.kosach.dictionary.repository

import com.kosach.dictionary.model.CreateWord
import com.kosach.dictionary.model.Word
import kotlinx.coroutines.flow.Flow

interface WordRepository {

    fun createWord(createWord: CreateWord): Flow<Word>

}