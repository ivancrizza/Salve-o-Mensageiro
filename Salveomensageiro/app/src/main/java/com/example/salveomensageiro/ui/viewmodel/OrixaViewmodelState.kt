package com.example.salveomensageiro.ui.viewmodel

import com.example.salveomensageiro.data.Orixa

sealed class OrixaViewmodelState {
    data class GetOrixas(val orixa: List<Orixa>) : OrixaViewmodelState()

    object InitialState : OrixaViewmodelState()
}