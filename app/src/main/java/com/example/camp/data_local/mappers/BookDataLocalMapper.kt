package com.example.camp.data_local.mappers

import com.example.camp.data_local.model.BookDataLocal
import com.example.camp.domain.model.Book

//cria uma extensão do livro para criar uma instância do BookDataLocal
fun Book.toDao(): BookDataLocal = BookDataLocal(
    id = this.id,
    name = this.name,
    author = this.author,
    pages = this.pages,
    editor = this.editor,
    originName = this.originName,
    date = this.date,
    isbn10 = this.isbn10,
    isbn13 = this.isbn13,
    language = this.language,
    review = this.review,
    imageUrl = this.imageUrl
)

fun BookDataLocal.toDomain(): Book = Book(
    id = this.id ?: "",
    name = this.name ?: "",
    author = this.author ?: "",
    pages = this.pages ?: "",
    editor = this.editor ?: "",
    originName = this.originName ?: "",
    date = this.date ?: "",
    isbn10 = this.isbn10 ?: "",
    isbn13 = this.isbn13 ?: "",
    language = this.language ?: "",
    review = this.review ?: "",
    imageUrl = this.imageUrl ?: ""
)