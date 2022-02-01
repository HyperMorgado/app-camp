package com.example.camp.data_remote.datasource

import com.example.camp.data.datasource.LoginDataSource
import com.example.camp.domain.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginDataSourceImpl: LoginDataSource {
    override fun login(email: String, password: String): Flow<User> = flow {

        delay(3_000)
        throw Exception("Algo deu errado")

        emit(User(
            name = "Pri",
            birthdate = "06/06/2005",
            gender = "Fem",
            accessToken = "1234"
        ))
    }
}