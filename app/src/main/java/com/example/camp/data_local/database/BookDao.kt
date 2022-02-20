package com.example.camp.data_local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.camp.data_local.model.BookDataLocal


@Dao
interface BookDao {

    //funções de manipulação do banco de dados
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addBooks(bookList: List<BookDataLocal>)

    //Selecionando todos os dados da tabela Books
    @Query("SELECT * FROM Books")
    fun getBooks(): List<BookDataLocal>
}