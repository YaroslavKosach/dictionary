package com.kosach.dictionary.repository

import com.kosach.dictionary.model.CreateWord
import com.kosach.dictionary.model.Word
import com.kosach.dictionary.repository.dao.WordDao
import com.kosach.dictionary.repository.model.WordEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject


class WordRepositoryImp @Inject constructor(
    private val dao: WordDao
) : WordRepository {

    override fun createWord(createWord: CreateWord): Flow<Word> = flow {
        val id = dao.insert(
            WordEntity(
                id = 0,
                englishValue = createWord.englishValue,
                ukraineValue = createWord.ukraineValue,
                description = createWord.description,
            )
        )
        emit(
            Word(
                id = id,
                englishValue = createWord.englishValue,
                ukraineValue = createWord.ukraineValue,
                description = createWord.description,
            )
        )
    }.flowOn(Dispatchers.IO)

}