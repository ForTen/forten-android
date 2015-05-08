package com.forten.android.networks.responses

/**
 * Created by mspark on 2015. 5. 8..
 */
public open class BasicResponse {
    class Error {
        var message: String? = null
    }

    var success: Boolean = false
    var error: Error? = null
}