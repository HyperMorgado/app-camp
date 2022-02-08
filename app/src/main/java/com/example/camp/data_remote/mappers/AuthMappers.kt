package com.example.camp.data_remote.mappers

import com.example.camp.data_remote.model.LoginResponse
import com.example.camp.domain.model.User

fun LoginResponse.toDomain(accessToken: String) = User(
    name = this.name,
    birthdate = this.birthdate,
    gender = this.gender,
    accessToken = accessToken,
    id = this.id
)