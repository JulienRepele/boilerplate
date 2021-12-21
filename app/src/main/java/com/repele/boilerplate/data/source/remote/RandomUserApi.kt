package com.repele.boilerplate.data.source.remote

import retrofit2.http.GET

interface RandomUserApi {

    @GET("api")
    suspend fun getUsers(): ApiUserListResponse

    companion object {
        const val BASE_URL = "https://randomuser.me/"
    }
}
