package com.forten.android.networks.services

import com.forten.android.networks.responses.UserResponse
import retrofit.Callback
import retrofit.http.Field
import retrofit.http.POST

/**
 * Created by mspark on 2015. 5. 8..
 */
public interface UserService {
    @POST ("/api/regist")
    fun register(@Field ("email") email: String,
                 @Field ("username") username: String,
                 @Field ("password") password: String,
                 @Field ("password_repeat") passwordRepeat: String,
                 callback: Callback<UserResponse>)

    @POST ("/api/login")
    fun login(@Field ("email") email: String,
              @Field ("password") password: String,
              callback: Callback<UserResponse>)
}
