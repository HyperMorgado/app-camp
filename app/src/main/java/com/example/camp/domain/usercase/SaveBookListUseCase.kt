package com.example.camp.domain.usercase

import com.example.camp.domain.model.Book
import com.example.camp.domain.repositories.BooksRepository
import com.example.camp.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SaveBookListUseCase(
    private val booksRepository: BooksRepository,
    scope: CoroutineScope
): UseCase<SaveBookListUseCase.Params, Unit>(scope = scope) {

    override fun run(params: Params?): Flow<Unit> = flowOf(
        booksRepository.saveBooks(
            bookList = params?.bookList ?: listOf()
        )
    )

    data class Params(
        val bookList: List<Book>
    )
}