package com.example.salveomensageiro.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import com.example.salveomensageiro.R


@Immutable
data class Orixas(
    @StringRes val name: Int,
    @DrawableRes val imageUrl: Int
)
private val orixas = listOf(
    R.drawable.nana to R.string.nana,
    R.drawable.omolu1 to R.string.omolu,
    R.drawable.oxumare to R.string.oxumare,
    R.drawable.oxalalufa to R.string.oxala,
    R.drawable.exu1 to R.string.exu,
    R.drawable.ogum to R.string.ogum,
    R.drawable.oxossi to R.string.oxossi,
    R.drawable.iemanja to R.string.yemanja,
    R.drawable.oya to R.string.iansa,
    R.drawable.oxum to R.string.oxun,
    R.drawable.oba to R.string.oba,
    R.drawable.ewa to R.string.ewa,
    R.drawable.xango to R.string.xango,
    R.drawable.logunede1 to R.string.logunEde,
    R.drawable.ossaim1 to R.string.ossain,
    R.drawable.ibeji1 to R.string.ibeji,
    R.drawable.iroko_c1 to R.string.iroko).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)