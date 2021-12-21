package com.repele.boilerplate.domain.usecase

import com.repele.boilerplate.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository,
) {
    operator fun invoke(email: String) = repository.getUser(email)
}