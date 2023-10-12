package com.example.salveomensageiro.data

import androidx.compose.runtime.Immutable


@Immutable
data class Orixas(
    val id: Int,
    val name: String,
    val imageUrl: String
)

val orixas = listOf(
    Orixas(
        1,
        "Nanã",
        "https://ocandomble.files.wordpress.com/2008/04/nana.jpg"

    ),
    Orixas(
        2,
        "Omolú",
        "https://ocandomble.files.wordpress.com/2008/04/omolu1.jpg"
    ),
    Orixas(
        3,
        "Oxumaré",
        "https://ocandomble.files.wordpress.com/2008/04/oxumare.jpg"
    ),
    Orixas(
        4,
        "Oxalá",
        "https://ocandomble.files.wordpress.com/2008/05/oxalalufa.jpg"
    ),

    Orixas(
        5,
        "Exu",
        "https://ocandomble.files.wordpress.com/2008/05/exu1.jpg"
    ),
    Orixas(
        6,
        "Ogum",
        "https://ocandomble.files.wordpress.com/2008/05/ogum.jpg"

    ),
    Orixas(
        7,
        "Oxóssi",
        "https://ocandomble.files.wordpress.com/2008/05/oxossi.jpg"
    ),
    Orixas(
        8,
        "Yemanjá",
        "https://ocandomble.files.wordpress.com/2008/05/iemanja.jpg"
    ),
    Orixas(
        9,
        "Iansã",
        "https://ocandomble.files.wordpress.com/2008/05/oya.jpg"
    ),
    Orixas(
        10,
        "Oxun",
        "Pendente, preciso resolver essa questão"
    ),
    Orixas(
        11,
        "Ewá",
        "https://ocandomble.files.wordpress.com/2008/06/ewa.jpg"
    ),
    Orixas(
        12,
        "Xangô",
        "https://ocandomble.files.wordpress.com/2008/07/xango.jpg"
    ),
    Orixas(
        13,
        "Logun Edé",
        "https://ocandomble.files.wordpress.com/2008/08/logunede1.jpg"
    ),
    Orixas(
        14,
        "Ossain",
        "https://ocandomble.files.wordpress.com/2008/08/logunede1.jpg"
    ),
    Orixas(
        15,
        "Ibeji",
        "https://ocandomble.files.wordpress.com/2008/08/ibeji1.jpg"
    ),
    Orixas(
        16,
        "Irôko",
        "https://ocandomble.files.wordpress.com/2008/08/iroko_c1.jpg"
    )
)

object OrixasRepository {
    fun getOrixas(): List<Orixas> = orixas
}