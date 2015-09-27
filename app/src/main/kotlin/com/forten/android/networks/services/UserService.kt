package com.forten.android.networks.services

import com.forten.android.networks.responses.UserResponse
import retrofit.Callback
import retrofit.http.Field
import retrofit.http.FormUrlEncoded
import retrofit.http.POST

public interface UserService {
    @POST ("/regist")
    @FormUrlEncoded
    fun register(@Field ("email") email: String,
                 @Field ("username") username: String,
                 @Field ("password") password: String,
                 @Field ("password_repeat") passwordRepeat: String,
                 callback: Callback<UserResponse>)

    @POST ("/login")
    @FormUrlEncoded
    fun login(@Field ("email") email: String,
              @Field ("password") password: String,
              callback: Callback<UserResponse>)
}
