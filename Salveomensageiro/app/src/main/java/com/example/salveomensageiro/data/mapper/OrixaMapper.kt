package com.example.salveomensageiro.data.mapper

import com.example.salveomensageiro.data.Orixa
import com.example.salveomensageiro.data.response.OrixaResponse

object OrixaMapper {
    fun convertResponseToModel(response: List<OrixaResponse>): List<Orixa> {
        return response.map {
            Orixa(
                name = it.title,
                imageUrl = it.image,
                day = it.day,
                color = it.color,
                symbols = it.symbols,
                elements = it.element,
                know = it.dominance,
                greetings = it.salute
            )
        }
    }
}