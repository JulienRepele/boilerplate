package com.repele.boilerplate.presentation.composable

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.repele.boilerplate.domain.model.User
import com.repele.boilerplate.domain.usecase.GetUserListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase,
) : ViewModel() {

    private val _users = MutableStateFlow(emptyList<User>())
    val users: StateFlow<List<User>> get() = _users

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            _users.update {
                getUserListUseCase()
            }
        }
    }
}
