package com.dicoding.submission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    val name: String,
    val description: String,
    val photo: String,
    val description2: String
) : Parcelable
