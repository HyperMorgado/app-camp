package com.example.camp.data.datasource.remote

import com.example.camp.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRemoteDataSource {

    fun getBooks(accessToken: String, query: String?): Flow<List<Book>>
}