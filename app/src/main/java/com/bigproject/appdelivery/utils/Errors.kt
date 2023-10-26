package com.bigproject.appdelivery.utils

import com.bigproject.appdelivery.data.dataApiRest.error.ServiceError

data class Errors (
    var isError: Boolean = false,
    var message: String = "",
    var error: ServiceError? = null
)