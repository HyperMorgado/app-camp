package com.example.camp.di

import com.example.camp.data.datasource.remote.BooksRemoteDataSource
import com.example.camp.data.datasource.remote.LoginRemoteDataSource
import com.example.camp.data_remote.datasource.BooksRemoteDataSourceImpl
import com.example.camp.data_remote.datasource.LoginRemoteDataSourceImpl
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

    single<LoginRemoteDataSource> {
        LoginRemoteDataSourceImpl(get())
    }

    single<BooksRemoteDataSource> {
        BooksRemoteDataSourceImpl(get())
    }
}