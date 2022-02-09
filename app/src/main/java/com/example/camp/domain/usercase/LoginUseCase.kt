package com.example.camp.domain.usercase

import com.example.camp.domain.exception.InvalidEmailException
import com.example.camp.domain.exception.InvalidPasswordException
import com.example.camp.domain.model.User
import com.example.camp.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.Flow

class LoginUseCase(
    private val loginRepository: LoginRepository
) {

    //faz a ponte com a camada de repository para fazer o login
    operator fun invoke(params: Params): Flow<User> = when {
        params.email.isEmpty() -> throw InvalidEmailException()
        params.password.isEmpty() -> throw InvalidPasswordException()
        else -> {
            loginRepository.login(
                email = params.email,
                password = params.password
            )
        }
    }

    data class Params(
        val email: String,
        val password: String
    )


}