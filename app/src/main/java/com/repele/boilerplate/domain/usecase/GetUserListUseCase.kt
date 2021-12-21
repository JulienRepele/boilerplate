package com.repele.boilerplate.domain.usecase

import com.repele.boilerplate.domain.repository.UserRepository
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(
    private val repository: UserRepository,
) {

    suspend operator fun invoke() = repository.getUserList()
}