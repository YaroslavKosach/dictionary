package com.kosach.dictionary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.kosach.dictionary.databinding.ActivityMainBinding
import com.kosach.dictionary.model.CreateWord
import com.kosach.dictionary.use_case.CreateWordUseCase
import com.kosach.dictionary.utils.Tags.APP_TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var createWordUseCase: CreateWordUseCase

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        binding.fab.setOnClickListener {
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
}