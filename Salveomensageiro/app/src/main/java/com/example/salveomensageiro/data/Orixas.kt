package com.example.salveomensageiro.data

import androidx.compose.runtime.Immutable


@Immutable
data class Orixas(
    val id: Long,
    val name: String,
    val imageUrl: String
)

val orixas = listOf(
    Orixas(
        1L,
        "Nanã",
        "https://ocandomble.files.wordpress.com/2008/04/nana.jpg"

    ),
    Orixas(
        2L,
        "Omolú",
        "https://ocandomble.files.wordpress.com/2008/04/omolu1.jpg"
    ),
    Orixas(
        3L,
        "Oxumaré",
        "https://ocandomble.files.wordpress.com/2008/04/oxumare.jpg"
    ),
    Orixas(
        4L,
        "Oxalá",
        "https://ocandomble.files.wordpress.com/2008/05/oxalalufa.jpg"
    ),

    Orixas(
        5L,
        "Exu",
        "https://ocandomble.files.wordpress.com/2008/05/exu1.jpg"
    ),
    Orixas(
        6L,
        "Ogum",
        "https://ocandomble.files.wordpress.com/2008/05/ogum.jpg"

    ),
    Orixas(
        7L,
        "Oxóssi",
        "https://ocandomble.files.wordpress.com/2008/05/oxossi.jpg"
    ),
    Orixas(
        8L,
        "Yemanjá",
        "https://ocandomble.files.wordpress.com/2008/05/iemanja.jpg"
    ),
    Orixas(
        9L,
        "Iansã",
        "https://ocandomble.files.wordpress.com/2008/05/oya.jpg"
    ),
    Orixas(
        10L,
        "Oxun",
        "Pendente, preciso resolver essa questão"
    ),
    Orixas(
        11L,
        "Ewá",
        "https://ocandomble.files.wordpress.com/2008/06/ewa.jpg"
    ),
    Orixas(
        12L,
        "Xangô",
        "https://ocandomble.files.wordpress.com/2008/07/xango.jpg"
    ),
    Orixas(
        13L,
        "Logun Edé",
        "https://ocandomble.files.wordpress.com/2008/08/logunede1.jpg"
    ),
    Orixas(
        14L,
        "Ossain",
        "https://ocandomble.files.wordpress.com/2008/08/logunede1.jpg"
    ),
    Orixas(
        15L,
        "Ibeji",
        "https://ocandomble.files.wordpress.com/2008/08/ibeji1.jpg"
    ),
    Orixas(
        16L,
        "Irôko",
        "https://ocandomble.files.wordpress.com/2008/08/iroko_c1.jpg"
    )
)

object OrixasRepository {
    fun getOrixas(): List<Orixas> = orixas
}