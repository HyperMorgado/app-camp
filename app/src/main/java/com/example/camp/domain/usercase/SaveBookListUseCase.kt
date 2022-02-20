package com.example.camp.domain.usercase

import com.example.camp.domain.model.Book
import com.example.camp.domain.repositories.BooksRepository

class SaveBookListUseCase(
    private val booksRepository: BooksRepository
) {

    operator fun invoke(params: Params) = booksRepository.saveBooks(
        bookList = params.bookList
    )
    data class Params(
        val bookList: List<Book>
    )
}