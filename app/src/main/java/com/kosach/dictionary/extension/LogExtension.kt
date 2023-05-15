package com.kosach.dictionary.extension

import android.util.Log

fun String.log(tag: String) {
    Log.d(tag, this)
}

fun String.log(tag: String, exception: Throwable) {
    Log.d(tag, this, exception)
}