package com.olxgroup.priyanallan.usercategories.repository.remote

import android.content.Context
import com.olxgroup.priyanallan.usercategories.repository.model.ImageCategory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface ApiModule {

    companion object {

        private const val BASE_URL = "https://picsum.photos"
        private const val REQUEST_TIMEOUT_SECS = 30L

        private var apiModuleInstance: ApiModule? = null

        fun getInstance(context: Context): ApiModule? {
            if (apiModuleInstance == null) {
                apiModuleInstance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(createOkHttpClient(context))
                    .build()
                    .create(ApiModule::class.java)
            }
            return apiModuleInstance
        }

        private fun createOkHttpClient(context: Context) =
            OkHttpClient.Builder().apply {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BASIC
                })
                connectTimeout(REQUEST_TIMEOUT_SECS, TimeUnit.SECONDS)
            }
                .build()
    }

    @GET("/v2/list")
    fun getCategories(@Query("limit") categoryLimit: Int): Call<List<ImageCategory>>
}