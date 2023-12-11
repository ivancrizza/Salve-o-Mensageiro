package com.example.salveomensageiro.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OrixasDetail(
    val id: Int,
    @DrawableRes val imageUrl: Int,
    @StringRes val name: Int,
    val day: String,
    val color: String,
    val symbols: String,
    val elements: String,
    val know: String,
    val greetings: String
)