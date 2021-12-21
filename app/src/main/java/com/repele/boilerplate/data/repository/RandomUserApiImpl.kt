package com.repele.boilerplate.data.repository

import com.repele.boilerplate.data.source.remote.RandomUserApi
import com.repele.boilerplate.data.toUserList
import com.repele.boilerplate.domain.model.User
import com.repele.boilerplate.domain.repository.UserRepository
import javax.inject.Inject

class RandomUserApiImpl @Inject constructor(
    private val api: RandomUserApi,
) : UserRepository {

    private val pictureList = emptyList<User>().toMutableList()
    override suspend fun getUserList(): List<User> {
        return api.getUsers().toUserList()
    }

    override fun getUser(email: String): User? {
        return pictureList.firstOrNull { it.email == email }
    }
}