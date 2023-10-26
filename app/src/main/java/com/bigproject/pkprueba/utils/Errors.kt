package com.bigproject.pkprueba.utils

import com.bigproject.pkprueba.data.dataApiRest.error.ServiceError

data class Errors (
    var isError: Boolean = false,
    var message: String = "",
    var error: ServiceError? = null
)