package com.example.camp.di

import com.example.camp.presentation.viewmodel.BookListViewModel
import com.example.camp.presentation.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { BookListViewModel(get()) }
}