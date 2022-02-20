package com.example.camp.di

import androidx.room.Room
import com.example.camp.data_local.database.BookDatabase
import com.example.camp.data_local.utils.LocalConstants.BOOK_DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    //mostra para o koin como criar uma instância do banco de dados
    single {

        Room.databaseBuilder(
            androidContext(),
            BookDatabase::class.java,
            BOOK_DATABASE_NAME

        ).allowMainThreadQueries().build()
    }


    single { get<BookDatabase>().bookDao() }

}