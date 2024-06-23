package br.com.salveomensageiro.data

import androidx.compose.runtime.Immutable


@Immutable
data class Orixa(
    val name: String = "",
    val imageUrl: String = "",
    val day: String = "",
    val color: String = "",
    val symbols: String = "",
    val elements: String = "",
    val know: String = "",
    val greetings: String = ""
)