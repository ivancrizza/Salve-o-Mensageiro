package com.example.salveomensageiro.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.salveomensageiro.data.mapper.OrixaMapper
import com.example.salveomensageiro.data.repository.OrixaRepository
import kotlinx.coroutines.launch

class OrixasViewmodel(
    private val orixaRepository: OrixaRepository,
) : BaseOrixaViewmodel() {
    private val _state = MutableLiveData<OrixaViewmodelState>()
    val state: LiveData<OrixaViewmodelState> = _state

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