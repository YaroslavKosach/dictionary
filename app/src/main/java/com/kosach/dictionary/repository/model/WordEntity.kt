package com.kosach.dictionary.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kosach.dictionary.utils.BadPerson
import com.kosach.dictionary.utils.TypeError
import java.util.Date

@Entity(tableName = "WordTable")
data class WordEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo("id") val id: Int,
    @ColumnInfo(name = "english_value") val englishValue: String,
    @ColumnInfo(name = "ukraine_value") val ukraineValue: String,
    @ColumnInfo(name = "description") val description: String?,

    //Integer
    @ColumnInfo("test_min_long") val testMinLong: Long = Long.MIN_VALUE,
    @ColumnInfo("test_max_long") val testMaxLong: Long = Long.MAX_VALUE,

    //Real
    @ColumnInfo("test_min_double") val testMinDouble: Double = Double.MIN_VALUE,
    @ColumnInfo("test_max_double") val testMaxDouble: Double = Double.MAX_VALUE,

    //Bool via integer
    @ColumnInfo("test_bool_false") val testBoolFalse: Boolean = false,
    @ColumnInfo("test_bool_true") val testBoolTrue: Boolean = true,

    //Blob
    @ColumnInfo("test_blob") val byteArray: ByteArray = "Andrey".toByteArray(),

    //bad person
    @ColumnInfo("bad_person") val badPerson: BadPerson = BadPerson(),

    //the worst bad person (like putin)
    @ColumnInfo("bad_person_list") val badPersonList: List<BadPerson> = arrayListOf(
        BadPerson(),
        BadPerson()
    ),

    //test enum
    @ColumnInfo("error_type") val error_type: TypeError = TypeError.HUMAN,


    //timestamp
    @ColumnInfo("timestamp") val timestamp: Date = Date(),

    )