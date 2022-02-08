package com.example.camp.di

import com.example.camp.data.datasource.BooksDataSource
import com.example.camp.data.datasource.LoginDataSource
import com.example.camp.data_remote.datasource.BooksDataSourceImpl
import com.example.camp.data_remote.datasource.LoginDataSourceImpl
import com.example.camp.data_remote.service.AuthService
import com.example.camp.data_remote.service.BookService
import com.example.camp.data_remote.utils.ApiConstants
import com.example.camp.data_remote.utils.WebServiceFactory
import org.koin.dsl.module

val dataRemoteModule = module {
    single<AuthService> {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single<BookService> {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single { WebServiceFactory.providerOkHttpClient() }

    single<LoginDataSource> {
        LoginDataSourceImpl(get())
    }

    single<BooksDataSource> {
        BooksDataSourceImpl(get())
    }
}