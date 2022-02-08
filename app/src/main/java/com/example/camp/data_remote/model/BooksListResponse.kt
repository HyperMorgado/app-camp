package com.example.camp.data_remote.model

import com.google.gson.annotations.SerializedName

class BooksListResponse(
    @SerializedName("data")
    val data: List<BookResponse>
)
