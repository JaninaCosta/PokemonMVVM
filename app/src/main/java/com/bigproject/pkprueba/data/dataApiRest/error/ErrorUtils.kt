package com.bigproject.pkprueba.data.dataApiRest.error

import com.bigproject.pkprueba.data.dataApiRest.services.RETROFIT_DELIVERY
import java.io.IOException
import retrofit2.Response

object ErrorUtils {
    fun parseError(response: Response<*>): ServiceError {
        RETROFIT_DELIVERY.settingService()

        val converter = RETROFIT_DELIVERY.retrofit.responseBodyConverter<ServiceError>(
            ServiceError::class.java,
            arrayOfNulls(0)
        )

        val error: ServiceError

        error = try {
            converter.convert(response.errorBody())!!
        } catch (e: IOException) {
            return ServiceError()
        }

        return error
    }
}