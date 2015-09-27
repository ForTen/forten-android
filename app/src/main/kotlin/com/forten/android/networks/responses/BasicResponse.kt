package com.forten.android.networks.responses

import com.forten.android.networks.models.Error

public open class BasicResponse {
    var success: Boolean = false
    var error: Error? = null
}