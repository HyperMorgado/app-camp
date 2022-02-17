package com.example.camp.data.datasource.remote

import com.example.camp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRemoteDataSource {

    fun login(email: String, password: String): Flow<User>
}