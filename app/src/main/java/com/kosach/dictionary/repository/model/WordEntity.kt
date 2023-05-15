package com.kosach.dictionary.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WordTable")
data class WordEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo("id") val id: Int,
    @ColumnInfo(name = "english_value") val englishValue: String,
    @ColumnInfo(name = "ukraine_value") val ukraineValue: String,
    @ColumnInfo(name = "description") val description: String,
)