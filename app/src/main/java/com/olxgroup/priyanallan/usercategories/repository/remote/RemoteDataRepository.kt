package com.olxgroup.priyanallan.usercategories.repository.remote

import com.olxgroup.priyanallan.usercategories.repository.model.ImageCategory
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.net.ssl.HttpsURLConnection

class RemoteDataRepository : KoinComponent {

    interface ApiRequestCallback<T> {
        fun onApiRequestSucceeded(content: T?)
        fun onApiRequestFailed(reason: String)
    }

    private val apiModule by inject<ApiModule>()

    /**
     * Retrieve categories based on the requested number of items.
     */
    fun getImageCategories(limit: Int, callback: ApiRequestCallback<List<ImageCategory>>) {

        apiModule
            .getCategories(limit)
            .enqueue(object : Callback<List<ImageCategory>> {
                override fun onFailure(call: Call<List<ImageCategory>>, t: Throwable) {
                    callback.onApiRequestFailed(t.toString())
                }

                override fun onResponse(
                    call: Call<List<ImageCategory>>,
                    response: Response<List<ImageCategory>>
                ) {
                    when (response.code()) {
                        HttpsURLConnection.HTTP_OK ->
                            callback.onApiRequestSucceeded(response.body())
                        else ->
                            callback.onApiRequestFailed("Http Failure: " + response.code())
                    }
                }

            })
    }
}