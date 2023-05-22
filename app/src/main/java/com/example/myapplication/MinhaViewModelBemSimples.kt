package com.example.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MinhaViewModelBemSimples : ViewModel(){

    private  val _contadorDaViewModel  = MutableStateFlow(0)
    val contadprDaViewPublico : StateFlow<Int> get() = _contadorDaViewModel

    fun incrementoContador(){
        _contadorDaViewModel.value = _contadorDaViewModel.value + 1
    }

    fun desincrementoContador(){
        _contadorDaViewModel.value = _contadorDaViewModel.value - 1
    }



}