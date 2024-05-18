package br.com.salveomensageiro.domain

import br.com.salveomensageiro.data.repository.OrixaRepository
import br.com.salveomensageiro.data.response.OrixaResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class OrixaRepositoryImpl(private val jsonString: String) : OrixaRepository {
    override suspend fun getAllOrixas(): List<OrixaResponse> {
        val gson = Gson()
        val type = object : TypeToken<List<OrixaResponse>>() {}.type
        return gson.fromJson(jsonString, type)
    }
}