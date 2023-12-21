package com.example.salveomensageiro.ui.viewmodel

import com.example.salveomensageiro.data.Orixa

sealed class OrixaViewmodelState {
    data class getOrixas(val orixa: List<Orixa>) : OrixaViewmodelState()
}