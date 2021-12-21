package com.repele.boilerplate.data.source.remote

import com.google.gson.annotations.SerializedName

class ApiUserListResponse(
    @SerializedName("results") val users: List<ApiUser>,
    @SerializedName("info") val info: ApiInfo?,
)

class ApiInfo(
    @SerializedName("seed") val seed: String,
    @SerializedName("results") val results: Int,
    @SerializedName("page") val pageIndex: Int,
    @SerializedName("version") val apiVersion: String?,
)