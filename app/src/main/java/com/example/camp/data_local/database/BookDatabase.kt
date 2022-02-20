package com.example.camp.data_local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.camp.data_local.model.BookDataLocal

//cria essa classe abstrata, pois não terá a implementação dos métodos
@Database(entities = [BookDataLocal::class], version = 1)
abstract class BookDatabase: RoomDatabase() {

    abstract fun bookDao(): BookDao
}