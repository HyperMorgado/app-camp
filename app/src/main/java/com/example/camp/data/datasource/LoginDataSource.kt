package com.example.camp.data.datasource

import com.example.camp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginDataSource {

    fun login(email: String, password: String): Flow<User>
}