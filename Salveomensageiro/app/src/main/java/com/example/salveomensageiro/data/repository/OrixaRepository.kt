package com.example.salveomensageiro.data.repository

import android.content.Context
import com.example.salveomensageiro.data.Orixa
import com.example.salveomensageiro.data.response.OrixaResponse

interface OrixaRepository {
    suspend fun getAllOrixas(): List<OrixaResponse>
}