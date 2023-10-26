package com.bigproject.pkprueba.utils

import com.bigproject.pkprueba.data.dataApiRest.error.ServiceError

sealed class Resource<T>(
    val data: T? = null,
    val error: ServiceError? = null,
    val errorExcepcion: Exception? = null,
    val message: String? = null,
    val isError: Boolean = false
) {

    // We'll wrap our data in this 'Success'
    // class in case of success response from api
    class Success<T>(data: T) : Resource<T>(data = data)

    // We'll pass error message wrapped in this 'Error'
    // class to the UI in case of failure response
    class Error<T>(error: ServiceError) : Resource<T>(error = error)

    class ErrorAuthenticated<T>(error: ServiceError) : Resource<T>(error = error)
    class ErrorException<T>(message: String) : Resource<T>(message = message)
    class ErrorUnknown<T>(message: String) : Resource<T>(message = message)
    class ErrorWithoutInternet<T>(isError: Boolean, message: String) : Resource<T>(isError = isError, message = message)
}