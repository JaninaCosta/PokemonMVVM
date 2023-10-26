package com.bigproject.appdelivery.data.dataApiRest.api

import com.bigproject.appdelivery.R
import com.bigproject.appdelivery.core.AppController
import com.bigproject.appdelivery.data.dataApiRest.error.ErrorUtils
import com.bigproject.appdelivery.data.dataApiRest.error.ServiceError
import com.bigproject.appdelivery.helper.UtilidadesHelper
import com.bigproject.appdelivery.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

object RecursoApi {

    suspend fun <T> safeConsumeApi(apiToBeCalled: suspend () -> Response<T>): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                if (UtilidadesHelper.isInternetAvailable(AppController.mInstance.applicationContext)) {
                    val response: Response<T> = apiToBeCalled()

                    if (response.isSuccessful) {
                        // In case of success response we
                        // are returning Resource.Success object
                        // by passing our data in it.
                        Resource.Success(data = response.body()!!)
                    }
                    else {
                        val errorResponse: ServiceError = ErrorUtils.parseError(response)

                        if (errorResponse === null) {
                            Resource.ErrorUnknown(message = "Error desconocido")
                        } else if (response.code() == 401) {
                            Resource.ErrorAuthenticated(error = errorResponse)
                        } else {
                            Resource.Error(error = errorResponse)
                        }
                    }
                } else {
                    Resource.ErrorWithoutInternet(
                        isError = true,
                        message = AppController.mInstance.applicationContext.getString(R.string.error_internet_message)
                    )
                }
            } catch (e: Exception) {
                // Returning HttpException's message
                // wrapped in Resource.Error
                e.printStackTrace()
                Resource.ErrorException(message = e.message!!)
            }
        }
    }
}