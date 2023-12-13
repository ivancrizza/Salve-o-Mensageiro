package com.example.salveomensageiro.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.salveomensageiro.data.Orixas

class OrixasViewmodel : ViewModel() {
    private var _orixas = MutableLiveData<Orixas>()
    val orixas: LiveData<Orixas> = _orixas

    fun setOrixas(orixas: Orixas) {
        _orixas.value = orixas
    }
}