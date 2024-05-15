package br.com.salveomensageiro.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

open class BaseOrixaViewmodel() : ViewModel(), CoroutineScope {
    private val viewmodelJob = SupervisorJob()

    override val coroutineContext: CoroutineContext = Dispatchers.Main + viewmodelJob

    override fun onCleared() {
        super.onCleared()
        viewmodelJob.cancelChildren()
    }
}