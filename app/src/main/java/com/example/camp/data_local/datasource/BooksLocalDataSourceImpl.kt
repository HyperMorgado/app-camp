package com.example.camp.data_local.datasource

import com.example.camp.data.datasource.local.BooksLocalDataSource
import com.example.camp.data_local.utils.LocalConstants.ACCESS_TOKEN_KEY
import com.example.camp.data_local.utils.SharedPreferencesHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksLocalDataSourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper
): BooksLocalDataSource {
    override fun getAccessToken(): Flow<String> = flow {
        emit(sharedPreferencesHelper.getString(ACCESS_TOKEN_KEY))
    }
}