package com.example.camp.di

import com.example.camp.data.repositories.LoginRepositoryImpl
import com.example.camp.domain.repositories.LoginRepository
import org.koin.dsl.module

val dataModule = module {
    single<LoginRepository> {
        LoginRepositoryImpl(get())
    }
}