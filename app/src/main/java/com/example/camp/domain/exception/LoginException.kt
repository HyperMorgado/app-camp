package com.example.camp.domain.exception

open class LoginException: Exception()

class InvalidEmailException : LoginException()
class InvalidPasswordException : LoginException()