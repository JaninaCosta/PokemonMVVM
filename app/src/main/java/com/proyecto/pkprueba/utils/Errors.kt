package com.proyecto.pkprueba.utils

import com.proyecto.pkprueba.data.dataApiRest.error.ServiceError

data class Errors (
    var isError: Boolean = false,
    var message: String = "",
    var error: ServiceError? = null
)