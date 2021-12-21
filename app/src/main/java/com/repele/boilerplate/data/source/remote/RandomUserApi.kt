package com.repele.boilerplate.data.source.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserApi {

    /**
     * Get a page of users from the RandomUser API
     * @param seed allow you to always generate the same set of users. Same seed equals same user list
     * @param pageSize number of items per page
     * @param pageIndex index of the page, starts at 1
     *
     * More information on the API here : https://randomuser.me/documentation#pagination
     */
    @GET("api")
    suspend fun getUsers(
        @Query("seed") seed: String,
        @Query("results") pageSize: Int,
        @Query("page") pageIndex: Long,
    ): ApiUserListResponse

    companion object {
        const val BASE_URL = "https://randomuser.me/"
    }
}
