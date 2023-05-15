package com.kosach.dictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.kosach.dictionary.model.CreateWord
import com.kosach.dictionary.use_case.CreateWordUseCase
import com.kosach.dictionary.utils.Tags.APP_TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var createWordUseCase: CreateWordUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            val word = createWordUseCase(CreateWord(
                englishValue = "Word",
                ukraineValue = "Слово",
                description = "-"
            )).catch {exception ->
                "Error".log(APP_TAG, exception)
            }.collect {word ->
                "Result: ${word.id}".log(APP_TAG)
            }
        }
    }
}