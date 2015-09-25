package com.forten.android.networks.responses

/**
 * Created by mspark on 2015. 5. 8..
 */
public class UserResponse : BasicResponse() {
    class User {
        var id: String? = null
        var username: String? = null
    }

    var accessToken: String? = null
    var user: User? = null
}
