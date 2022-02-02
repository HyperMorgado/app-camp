package com.example.camp.data_remote.datasource

import com.example.camp.data.datasource.BooksDataSource
import com.example.camp.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksDataSourceImpl: BooksDataSource {

    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> = flow {

        val books: List<Book> = listOf(
            Book(
                id = 1,
                name = "Crossing the Clasm"
            ),
            Book(
                id = 2,
                name = "Change By Design"
            ),
            Book(
                id = 3,
                name = "The Making of a Manager"
            ),
            Book(
                id = 4,
                name = "Don't Make me Think"
            ),
            Book(
                id = 5,
                name = "Web design 101"
            )
        )

        query?.let {
            emit(books.filter { book ->
                book.name.trim().contains(it, true)
            })
        } ?: run {
            emit(books)
        }
    }
}