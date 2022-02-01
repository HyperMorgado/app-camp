package com.example.camp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.camp.domain.exception.EmptyBookLIstException
import com.example.camp.domain.model.Book
import com.example.camp.util.ViewState
import com.example.camp.util.postError
import com.example.camp.util.postSuccess
import kotlinx.coroutines.launch

class BookListViewModel : ViewModel() {

    private val _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    private val bookDataList: List<Book> by lazy { Book.getMockList() }

    private fun getBooks(input: String): List<Book> {
        if(input.isEmpty()) {
            return bookDataList
        }else {
            return bookDataList.filter { book ->
               book.name.contains(input, ignoreCase = true)
            }
        }
    }

    fun search(input: String = "") {
        viewModelScope.launch {
            getBooks(input).let { books ->
                when {
                    books.isNotEmpty() -> {
                        _bookListViewState.postSuccess(books)
                    }
                    else -> {
                        _bookListViewState.postError(EmptyBookLIstException())
                    }
                }
            }
        }
    }
}