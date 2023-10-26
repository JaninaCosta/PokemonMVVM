package com.bigproject.appdelivery.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bigproject.appdelivery.domain.ObtenerDetallePokemonUseCase
import com.bigproject.appdelivery.interfaz.detalle.DetallePokemonResponse
import com.bigproject.appdelivery.utils.Errors
import com.bigproject.appdelivery.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
    Project: AppDelivery
    Autor: Janina Costa
    Fecha: 24/10/2023
*/


@HiltViewModel
class DetallePokemonViewModel @Inject constructor(
    private val obtenerDetallePokemosUseCase : ObtenerDetallePokemonUseCase
    ) : ViewModel() {
    val onDetallePokemos = MutableLiveData<DetallePokemonResponse>()
    var apiErrorInternet = MutableLiveData<Errors>()
    var apiError = MutableLiveData<String>()

    fun obtenerDetallePokemon(id: Int) {
        viewModelScope.launch {
            val responseResource: Resource<DetallePokemonResponse> = obtenerDetallePokemosUseCase(id)
            try {
                when (responseResource) {
                    is Resource.Success -> {
                        onDetallePokemos.postValue(responseResource.data!!)
                    }
                    is Resource.Error -> {}
                    is Resource.ErrorAuthenticated -> {}
                    is Resource.ErrorException -> {}
                    is Resource.ErrorUnknown -> {}
                    is Resource.ErrorWithoutInternet -> {
                        apiErrorInternet.postValue(
                            Errors(
                                isError = responseResource.isError,
                                message = responseResource.message!!
                            )
                        )
                    }
                }
            }catch (e: Exception){
                apiError.postValue(e.message)
            }
        }
    }
}