package com.kosach.dictionary.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kosach.dictionary.utils.BadPerson
import com.kosach.dictionary.utils.TypeError
import java.lang.reflect.Type
import java.util.Date


class Converters {

    @TypeConverter
    fun fromBadPerson(value: String): BadPerson? {
        val gson = Gson()
        return gson.fromJson(value, BadPerson::class.java)
    }

    @TypeConverter
    fun badPersonToJson(badPerson: BadPerson): String {
        val gson = Gson()
        return gson.toJson(badPerson)
    }

    @TypeConverter
    fun fromBadPersonList(value: String): List<BadPerson> {
        val listType: Type = object : TypeToken<List<BadPerson>>() {}.type
        val gson = Gson()
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun badPersonToJson(badPersonList: List<BadPerson>): String {
        val listType: Type = object : TypeToken<List<BadPerson>>() {}.type
        val gson = Gson()
        return gson.toJson(badPersonList, listType)
    }

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }

    @TypeConverter
    fun toEnum(value: String): TypeError {
        return TypeError.valueOf(value)
    }

    @TypeConverter
    fun toString(date: TypeError): String {
        return date.toString()
    }


}