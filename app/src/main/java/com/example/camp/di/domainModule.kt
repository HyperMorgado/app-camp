package com.example.camp.di

import com.example.camp.domain.usercase.GetBookListUseCase
import com.example.camp.domain.usercase.LoginUseCase
import com.example.camp.domain.usercase.SaveBookListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {

    single { CoroutineScope(Dispatchers.IO) }

    factory { LoginUseCase(get(), get()) }
    factory { GetBookListUseCase(get(), get()) }
    factory { SaveBookListUseCase(get(), get()) }
}