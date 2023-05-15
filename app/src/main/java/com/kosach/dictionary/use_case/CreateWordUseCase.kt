package com.kosach.dictionary.use_case

import com.kosach.dictionary.model.CreateWord
import com.kosach.dictionary.model.Word
import com.kosach.dictionary.repository.WordRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreateWordUseCase @Inject constructor(
    private val wordRepository: WordRepository
) {

    operator fun invoke(createWord: CreateWord): Flow<Word> {
        return wordRepository.createWord(createWord)
    }

}