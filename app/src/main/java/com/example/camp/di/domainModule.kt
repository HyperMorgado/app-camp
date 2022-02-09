package com.example.camp.di

import com.example.camp.domain.usercase.LoginUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { LoginUseCase(get()) }
}