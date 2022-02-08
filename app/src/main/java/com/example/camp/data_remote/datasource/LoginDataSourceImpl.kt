package com.example.camp.data_remote.datasource

import com.example.camp.data.datasource.LoginDataSource
import com.example.camp.data_remote.mappers.toDomain
import com.example.camp.data_remote.model.LoginRequest
import com.example.camp.data_remote.service.AuthService
import com.example.camp.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginDataSourceImpl(
    private val authService: AuthService
): LoginDataSource {
    override fun login(email: String, password: String): Flow<User> = flow {

        val response = authService.signIn(LoginRequest(email, password))
        val accessToken = response.headers()["authorization"]
        if(response.isSuccessful) {
            response.body()?.let { loginResponse ->
                emit(loginResponse.toDomain(accessToken?: ""))
            }
        }
    }

}
