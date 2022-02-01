package com.example.camp.data.repositories

import com.example.camp.data.datasource.LoginDataSource
import com.example.camp.domain.model.User
import com.example.camp.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.Flow

class LoginRepositoryImpl(
    private val loginDataSource: LoginDataSource
): LoginRepository {

    override fun login(email: String, password: String): Flow<User> =
        loginDataSource.login(email, password)
}