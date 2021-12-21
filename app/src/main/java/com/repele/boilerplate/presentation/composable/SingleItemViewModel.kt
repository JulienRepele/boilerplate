package com.repele.boilerplate.presentation.composable

import androidx.lifecycle.ViewModel
import com.repele.boilerplate.domain.model.User
import com.repele.boilerplate.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class SingleItemViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
) : ViewModel() {

    private val _selectedUser = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> get() = _selectedUser

    fun selectUser(email: String) {
        _selectedUser.value = getUserUseCase(email)
    }
}