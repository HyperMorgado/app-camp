package com.example.camp.di

import com.example.camp.data.repositories.BooksRepositoryImpl
import com.example.camp.data.repositories.LoginRepositoryImpl
import com.example.camp.domain.repositories.BooksRepository
import com.example.camp.domain.repositories.LoginRepository
import org.koin.dsl.module

val dataModule = module {
    single<LoginRepository> {
        LoginRepositoryImpl(get(), get())
    }

    single<BooksRepository> {
        BooksRepositoryImpl(get())
    }
}