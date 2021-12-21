package com.repele.boilerplate.domain.repository

import com.repele.boilerplate.domain.model.User

interface UserRepository {
    suspend fun getUserList(): List<User>
    fun getUser(email: String): User?
}