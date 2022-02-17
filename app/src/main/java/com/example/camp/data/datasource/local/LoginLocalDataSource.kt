package com.example.camp.data.datasource.local

interface LoginLocalDataSource {

    fun saveAccessToken(accessToken: String)

}