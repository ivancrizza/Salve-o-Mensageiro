package br.com.salveomensageiro.data.repository

import br.com.salveomensageiro.data.response.OrixaResponse

interface OrixaRepository {
    suspend fun getAllOrixas(): List<OrixaResponse>
}