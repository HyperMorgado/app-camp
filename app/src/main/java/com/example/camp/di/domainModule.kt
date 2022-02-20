package com.example.camp.di

import com.example.camp.domain.usercase.GetBookListUseCase
import com.example.camp.domain.usercase.LoginUseCase
import com.example.camp.domain.usercase.SaveBookListUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { LoginUseCase(get()) }
    factory { GetBookListUseCase(get()) }
    factory { SaveBookListUseCase(get()) }
}