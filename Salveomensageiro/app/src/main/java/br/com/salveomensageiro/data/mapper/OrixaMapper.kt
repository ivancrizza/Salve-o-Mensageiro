package br.com.salveomensageiro.data.mapper

import br.com.salveomensageiro.data.response.OrixaResponse

object OrixaMapper {
    fun convertResponseToModel(response: List<OrixaResponse>): List<br.com.salveomensageiro.data.Orixa> {
        return response.map {
            br.com.salveomensageiro.data.Orixa(
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