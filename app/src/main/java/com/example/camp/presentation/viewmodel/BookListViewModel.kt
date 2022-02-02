package com.example.camp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.camp.domain.model.Book
import com.example.camp.domain.repositories.BooksRepository
import com.example.camp.util.ViewState
import com.example.camp.util.postError
import com.example.camp.util.postLoading
import com.example.camp.util.postSuccess
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BookListViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {

    private val _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun search(input: String = "") {
        viewModelScope.launch {
            _bookListViewState.postLoading()
            try {
                booksRepository.getBooks(accessToken = "123", input).collect {
                    if(it.isNotEmpty()) {
                        _bookListViewState.postSuccess(it)
                    }else {
                        _bookListViewState.postError(Exception("Algo deu errado"))
                    }
                }
            } catch(err: Exception) {
                _bookListViewState.postError(err)
            }
        }
    }
}