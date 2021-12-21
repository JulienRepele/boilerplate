package com.repele.boilerplate.data

import com.repele.boilerplate.data.source.remote.ApiUserListResponse
import com.repele.boilerplate.domain.model.User

fun ApiUserListResponse.toUserList(): List<User> = users.map { apiUser ->
    User(
        email = apiUser.email ?: return@map null,
        firstName = apiUser.name?.first ?: return@map null,
        lastName = apiUser.name.last ?: return@map null,
        thumbnailUrl = apiUser.picture?.largeUrl
    )
}.filterNotNull()
