package com.example.camp.domain.usercase

import com.example.camp.domain.model.Book
import com.example.camp.domain.repositories.BooksRepository
import com.example.camp.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow


class GetBookListUseCase(
    private val booksRepository: BooksRepository,
    scope: CoroutineScope
) : UseCase<GetBookListUseCase.Params, List<Book>>(scope = scope){

    override fun run(params: Params?): Flow<List<Book>> = booksRepository.getBooks(
        query = params?.input
    )

    data class Params(
        val input: String
    )
}