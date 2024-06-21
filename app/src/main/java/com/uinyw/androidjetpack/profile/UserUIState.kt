package com.uinyw.androidjetpack.profile

data class UserUIState(
    private val firstName: String,
    private val lastName: String,
    private val email: String,
    private val phone: String
) {

    fun withFirstName(firstName: String): UserUIState {
        return this.copy(firstName = firstName)
    }
    fun getFirstName(): String {
        return firstName
    }

    fun withLastName(lastName: String): UserUIState {
        return this.copy(lastName = lastName)
    }
    fun getLastName(): String {
        return lastName
    }

    fun withEmail(email: String): UserUIState {
        return this.copy(email = email)
    }
    fun getEmail(): String {
        return email
    }

    fun withPhone(phone: String): UserUIState {
        return this.copy(phone = phone)
    }
    fun getPhone(): String {
        return phone
    }
}