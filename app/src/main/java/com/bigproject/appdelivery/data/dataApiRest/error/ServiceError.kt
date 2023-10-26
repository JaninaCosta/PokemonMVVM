package com.bigproject.appdelivery.data.dataApiRest.error

import com.fasterxml.jackson.annotation.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("message", "error", "statusCode")
class ServiceError {
    @JsonProperty("message")
    var message: String? = null

    @JsonProperty("error")
    var error: String? = null

    @JsonProperty("statusCode")
    var statusCode: Int? = null

    /**
     * No args constructor for use in serialization
     */
    constructor() {}

    /**
     * @param message
     */
    constructor(mensaje: String) {
        message = mensaje
    }
}