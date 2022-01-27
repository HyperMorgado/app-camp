package com.example.camp.presentation.adapter

import com.example.camp.domain.model.Book

interface BookClickListener {

    fun onBookClickListener(book: Book)
}