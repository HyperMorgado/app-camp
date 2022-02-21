package com.example.camp.data.repositories

import com.example.camp.data.datasource.local.BooksLocalDataSource
import com.example.camp.data.datasource.remote.BooksRemoteDataSource
import com.example.camp.domain.model.Book
import com.example.camp.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class BooksRepositoryImpl(
    private val booksRemoteDataSource: BooksRemoteDataSource,
    private val booksLocalDataSource: BooksLocalDataSource
) : BooksRepository {

    override fun getBooks(query: String?): Flow<List<Book>> = flow {
        booksLocalDataSource.getAccessToken().collect {  token ->
            if(token.isNotEmpty()) {
                booksRemoteDataSource.getBooks(token, query).collect { bookList ->
                    emit(bookList)
                }
            } else {
                booksLocalDataSource.getBooks(query = query).collect { bookList ->
                    emit(bookList)
                }
            }
        }
    }

    override fun saveBooks(bookList: List<Book>) = booksLocalDataSource.saveBooks(
        bookList = bookList
    )
}