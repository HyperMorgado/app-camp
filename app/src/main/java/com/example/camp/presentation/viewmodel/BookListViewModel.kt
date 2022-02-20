package com.example.camp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.camp.domain.model.Book
import com.example.camp.domain.usercase.GetBookListUseCase
import com.example.camp.domain.usercase.SaveBookListUseCase
import com.example.camp.util.ViewState
import com.example.camp.util.postError
import com.example.camp.util.postLoading
import com.example.camp.util.postSuccess

class BookListViewModel(
    private val getBookListUseCase: GetBookListUseCase,
    private val saveBookListUseCase: SaveBookListUseCase
) : ViewModel() {

    private val _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun search(input: String = "") {
        _bookListViewState.postLoading()
        getBookListUseCase(
            params = GetBookListUseCase.Params(
                input = input
            ),
            onSuccess = {
                saveBooks(bookList = it)
                _bookListViewState.postSuccess(it)
            },
            onError = {
                _bookListViewState.postError(it)
            }
        )
    }

    private fun saveBooks(bookList: List<Book>) {
        saveBookListUseCase(
            params = SaveBookListUseCase.Params(
                bookList = bookList
            )
        )
    }
}