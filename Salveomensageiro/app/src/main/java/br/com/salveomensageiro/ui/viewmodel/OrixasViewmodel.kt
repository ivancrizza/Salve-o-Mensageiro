package br.com.salveomensageiro.ui.viewmodel

import br.com.salveomensageiro.data.repository.OrixaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OrixasViewmodel(
    private val orixaRepository: OrixaRepository,
) : BaseOrixaViewmodel() {
    private val _state = MutableStateFlow<OrixaViewmodelState>(OrixaViewmodelState.InitialState)
    val state: StateFlow<OrixaViewmodelState> = _state.asStateFlow()

    init {
        getOrixas()
    }

    fun getOrixas() {
        launch {
            val orixasResponse = orixaRepository.getAllOrixas()
            val orixa = br.com.salveomensageiro.data.mapper.OrixaMapper.convertResponseToModel(orixasResponse)
            _state.value = OrixaViewmodelState.GetOrixas(orixa = orixa)
        }
    }

    fun searchOrixaOnClick(search: String) {
        launch {
            val orixasResponse = orixaRepository.getAllOrixas()
            val orixa = br.com.salveomensageiro.data.mapper.OrixaMapper.convertResponseToModel(orixasResponse)
            val filteredOrixa = searchOrixas(search = search, orixa = orixa)
            _state.value = OrixaViewmodelState.GetOrixas(orixa = filteredOrixa)
        }
    }

    private fun searchOrixas(search: String, orixa: List<br.com.salveomensageiro.data.Orixa>): List<br.com.salveomensageiro.data.Orixa> {
        return orixa.filter { it.name.contains(search, ignoreCase = true) }
    }
}