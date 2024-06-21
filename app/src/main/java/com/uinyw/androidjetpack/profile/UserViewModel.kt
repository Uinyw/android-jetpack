package com.uinyw.androidjetpack.profile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UserViewModel: ViewModel() {

    private val _user = MutableStateFlow(UserUIState("John", "Doe", "jdoe@gmail.com", "1"))
    private val user: StateFlow<UserUIState> = _user.asStateFlow()


    fun getUser(): StateFlow<UserUIState> {
        return user
    }

    fun onFirstNameChange(firstName: String) {
        _user.update { it.withFirstName(firstName) }
    }

    fun onLastNameChange(lastName: String) {
        _user.update { it.withLastName(lastName) }
    }

    fun onEmailChange(email: String) {
        _user.update { it.withEmail(email) }
    }

    fun onPhoneChange(phone: String) {
        _user.update { it.withPhone(phone) }
    }
}