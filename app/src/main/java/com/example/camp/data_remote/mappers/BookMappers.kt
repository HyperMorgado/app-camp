package com.example.camp.data_remote.mappers

import com.example.camp.data_remote.model.BookResponse
import com.example.camp.domain.model.Book

fun List<BookResponse>.toDomain(): List<Book> {
    return this.map {
        Book(
            id = it.id ?:"",
            name = it.name ?:"",
            author = it.author?.first() ?:"",
            pages = it.pages ?:"",
            originName = it.originName ?:"",
            date = it.date ?:"",
            isbn10 = it.isbn10 ?:"",
            isbn13 = it.isbn13 ?:"",
            language = it.language ?:"",
            review = it.review ?:"",
            imageUrl = it.imageUrl ?:""
        )
    }
}