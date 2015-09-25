package com.forten.android.networks

import com.forten.android.networks.services.UserService
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.squareup.okhttp.OkHttpClient
import retrofit.RestAdapter
import retrofit.android.MainThreadExecutor
import retrofit.client.OkClient
import retrofit.client.Request
import retrofit.client.Response
import retrofit.converter.ConversionException
import retrofit.converter.GsonConverter
import retrofit.mime.TypedInput
import java.io.IOException
import java.lang.reflect.Type
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Created by mspark on 2015. 5. 8..
 */
public class ApiManager {
    companion object {
        public val BASE_HOST: String = "54.65.24.248"
        public val BASE_URL: String = "http://" + BASE_HOST

        private val CALLBACK_EXECUTOR = MainThreadExecutor()
        private val GSON_BUILDER = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)

        private val CONNECT_TIMEOUT_SECONDS = 5
        private val READ_TIMEOUT_SECONDS = 10

        private fun getRestAdapterBuilder(): RestAdapter.Builder {
            val okHttpClient = OkHttpClient()
            okHttpClient.setConnectTimeout(CONNECT_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
            okHttpClient.setReadTimeout(READ_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)

            return RestAdapter.Builder().setClient(object : OkClient(okHttpClient) {
                @Throws(IOException::class)
                override fun execute(request: Request): Response {
                    val response = super.execute(request)
                    val statusCode = response.getStatus()
                    if (statusCode >= 200 && statusCode < 300 && response.getBody() == null) {
                        throw IOException("response body is empty : ${response.getUrl()}, ${statusCode}, ${response.getReason()}, ${response.getHeaders()}")
                    }
                    return response
                }
            }).setEndpoint(BASE_URL).setExecutors(Executors.newSingleThreadExecutor(), CALLBACK_EXECUTOR).setConverter(object : GsonConverter(GSON_BUILDER.create()) {
                @Throws(ConversionException::class)
                override fun fromBody(body: TypedInput, type: Type): Any {
                    val obj = super.fromBody(body, type) ?: throw ConversionException("response object is null : ${body.mimeType()}, ${body.length()}, ${body.toString()}")
                    return obj
                }
            })
        }

        public fun getUserService(): UserService = getRestAdapterBuilder().build().create(UserService::class.java)
    }
}
