package com.example.camp.data.repositories

import com.example.camp.data.datasource.remote.BooksRemoteDataSource
import com.example.camp.domain.model.Book
import com.example.camp.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow

class BooksRepositoryImpl(
    private val booksRemoteDataSource: BooksRemoteDataSource
) : BooksRepository {

    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> =
        booksRemoteDataSource.getBooks(accessToken, query)
}