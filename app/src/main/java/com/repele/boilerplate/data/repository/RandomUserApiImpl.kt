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
        return api.getUsers(
            seed = DEFAULT_SEED,
            pageSize = DEFAULT_PAGE_SIZE,
            pageIndex = DEFAULT_REQUESTED_PAGE_INDEX
        ).toUserList().also { pictureList.addAll(it) }
    }

    override fun getUser(email: String): User? {
        return pictureList.firstOrNull { it.email == email }
    }

    companion object {
        private const val DEFAULT_PAGE_SIZE = 20
        private const val DEFAULT_SEED = "azerty"
        private const val DEFAULT_REQUESTED_PAGE_INDEX = 1L

    }
}