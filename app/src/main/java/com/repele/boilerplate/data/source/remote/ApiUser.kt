package com.repele.boilerplate.data.source.remote

import com.google.gson.annotations.SerializedName

class ApiUser(
    @SerializedName("email") val email: String?,
    @SerializedName("name") val name: ApiName?,
    @SerializedName("picture") val picture: ApiPicture?,
)

class ApiName(
    @SerializedName("title") val title: String?,
    @SerializedName("first") val first: String?,
    @SerializedName("last") val last: String?,
)

class ApiPicture(
    @SerializedName("large") val largeUrl: String?,
    @SerializedName("medium") val mediumUrl: String?,
    @SerializedName("thumbnail") val thumbnailUrl: String?,
)
