package com.example.camp.di

import com.example.camp.data.datasource.LoginDataSource
import com.example.camp.data_remote.datasource.LoginDataSourceImpl
import org.koin.dsl.module

val dataRemoteModule = module {
    single<LoginDataSource> {
        LoginDataSourceImpl()
    }
}