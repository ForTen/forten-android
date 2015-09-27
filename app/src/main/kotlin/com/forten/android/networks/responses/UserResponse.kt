package com.forten.android.networks.responses

import com.forten.android.networks.models.User

public class UserResponse : BasicResponse() {
    var accessToken: String? = null
    var user: User? = null
}
