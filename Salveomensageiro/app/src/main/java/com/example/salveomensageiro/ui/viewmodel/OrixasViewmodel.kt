package com.example.salveomensageiro.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.salveomensageiro.data.mapper.OrixaMapper
import com.example.salveomensageiro.data.repository.OrixaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OrixasViewmodel(
    private val orixaRepository: OrixaRepository,
) : BaseOrixaViewmodel() {
    private val _state = MutableStateFlow<OrixaViewmodelState>(OrixaViewmodelState.initialState)
    val state: StateFlow<OrixaViewmodelState> = _state.asStateFlow()

    init {
        getOrixas()
    }

    fun getOrixas() {
        launch {
            val orixasResponse = orixaRepository.getAllOrixas()
            val orixa = OrixaMapper.convertResponseToModel(orixasResponse)
            _state.value = OrixaViewmodelState.getOrixas(orixa = orixa)
        }
    }
}