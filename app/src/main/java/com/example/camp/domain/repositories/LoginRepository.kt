package com.example.camp.domain.repositories

import com.example.camp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    fun login(email:String, password: String): Flow<User>
}