package com.bigproject.appdelivery.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bigproject.appdelivery.data.dataApiRest.model.ApiResponse
import com.bigproject.appdelivery.domain.ObtenerListadoPokemosUseCase
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
class ListadoPokemonViewModel @Inject constructor(
    private val obtenerListadoPokemosUseCase : ObtenerListadoPokemosUseCase,
    ) : ViewModel() {
    val onListadoPokemon = MutableLiveData<ApiResponse>()
    var apiErrorInternet = MutableLiveData<Errors>()
    var apiError = MutableLiveData<String>()

    fun obtenerListadoPokemon(offset: Int, limit: Int) {
        viewModelScope.launch {
            val responseResource: Resource<ApiResponse> = obtenerListadoPokemosUseCase(offset, limit)
            try {
                when (responseResource) {
                    is Resource.Success -> {
                        onListadoPokemon.postValue(responseResource.data!!)
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