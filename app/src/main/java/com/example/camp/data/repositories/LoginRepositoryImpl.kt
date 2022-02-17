package com.example.camp.data.repositories

import com.example.camp.data.datasource.local.LoginLocalDataSource
import com.example.camp.data.datasource.remote.LoginRemoteDataSource
import com.example.camp.domain.model.User
import com.example.camp.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class LoginRepositoryImpl(
    private val loginRemoteDataSource: LoginRemoteDataSource,
    private val loginLocalDataSource: LoginLocalDataSource
): LoginRepository {

    override fun login(email: String, password: String): Flow<User> = flow {
        loginRemoteDataSource.login(email, password).collect { userData ->
            loginLocalDataSource.saveAccessToken(accessToken = userData.accessToken)

            emit(userData)
        }
    }
}