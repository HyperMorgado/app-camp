package com.example.camp.domain.usercase

import com.example.camp.domain.model.Book
import com.example.camp.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow


class GetBookListUseCase(
    private val booksRepository: BooksRepository
) {

    operator fun invoke(params: Params): Flow<List<Book>> = booksRepository.getBooks(
        query = params.input
    )

    data class Params(
        val input: String
    )

}