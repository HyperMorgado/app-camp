package com.example.camp.data.datasource.local

import kotlinx.coroutines.flow.Flow

interface BooksLocalDataSource {

    fun getAccessToken(): Flow<String>
}