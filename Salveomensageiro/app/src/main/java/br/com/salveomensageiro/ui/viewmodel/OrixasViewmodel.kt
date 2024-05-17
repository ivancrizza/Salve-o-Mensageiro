package br.com.salveomensageiro.ui.viewmodel

import br.com.salveomensageiro.data.Orixa
import br.com.salveomensageiro.data.mapper.OrixaMapper
import br.com.salveomensageiro.data.repository.OrixaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OrixasViewmodel(
    private val orixaRepository: OrixaRepository,
) : BaseOrixaViewmodel() {
    private val _state = MutableStateFlow<OrixaViewmodelState>(OrixaViewmodelState.InitialState)
    val state: StateFlow<OrixaViewmodelState> = _state
    private var originalOrixaList: List<Orixa> = listOf()
    init {
        getOrixas()
    }

    private fun getOrixas() {
        launch {
            val orixasResponse = orixaRepository.getAllOrixas()
            originalOrixaList = OrixaMapper.convertResponseToModel(orixasResponse)
            _state.value = OrixaViewmodelState.GetOrixas(orixa = originalOrixaList)
        }
    }



    fun searchOrixaOnClick(search: String) {
        launch {
            val filteredOrixa = searchOrixas(search = search, orixa = originalOrixaList)
            _state.value = OrixaViewmodelState.GetOrixas(orixa = filteredOrixa)
        }
    }

    private fun searchOrixas(search: String, orixa: List<Orixa>): List<Orixa> {
        return orixa.filter { it.name.contains(search, ignoreCase = true) }
    }

    fun resetSearch() {
        _state.value = OrixaViewmodelState.GetOrixas(orixa = originalOrixaList)
    }
}