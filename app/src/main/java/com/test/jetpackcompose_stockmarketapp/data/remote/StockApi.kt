package com.test.jetpackcompose_stockmarketapp.data.remote

import com.ramcosta.composedestinations.BuildConfig
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {

    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apiKey: String

    ): ResponseBody

    companion object {
        const val API_KEY = "JESPVMYRB59AV6IK"
        const val BASE_URL = "https://www.alphavanage.co"
    }
}