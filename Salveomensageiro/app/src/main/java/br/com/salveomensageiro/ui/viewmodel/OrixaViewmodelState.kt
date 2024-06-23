package br.com.salveomensageiro.ui.viewmodel

import br.com.salveomensageiro.data.Orixa

sealed class OrixaViewmodelState {
    data class GetOrixas(val orixa: List<Orixa>) : OrixaViewmodelState()

    object InitialState : OrixaViewmodelState()
}