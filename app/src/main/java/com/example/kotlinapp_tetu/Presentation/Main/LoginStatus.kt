package com.example.kotlinapp_tetu.Presentation.Main

sealed class LoginStatus

data class LoginSuccess(val email: String) : LoginStatus()
object LoginError: LoginStatus()

