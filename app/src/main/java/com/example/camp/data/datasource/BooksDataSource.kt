package com.example.camp.data.datasource

import com.example.camp.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksDataSource {

    fun getBooks(accessToken: String, query: String?): Flow<List<Book>>
}