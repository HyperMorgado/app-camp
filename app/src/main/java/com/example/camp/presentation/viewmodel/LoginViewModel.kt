package com.example.camp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.camp.domain.repositories.LoginRepository
import com.example.camp.util.ViewState
import com.example.camp.util.postNeutral

class LoginViewModel(
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val _loggedUserViewState = MutableLiveData<ViewState<Boolean>>()
    var loggedUserViewState = _loggedUserViewState as LiveData<ViewState<Boolean>>

    fun login(email: String, password: String) {

        //loginRepository.login()

       /*viewModelScope.launch {

            _loggedUserViewState.postLoading()

            delay(2_000)

            if(email.isNotEmpty() && password.isNotEmpty()) {
                _loggedUserViewState.postSuccess(true)
            }else {
                _loggedUserViewState.postError(LoginException())
            }
        }*/
    }

    fun resetViewState() {
        _loggedUserViewState.postNeutral()
    }
}