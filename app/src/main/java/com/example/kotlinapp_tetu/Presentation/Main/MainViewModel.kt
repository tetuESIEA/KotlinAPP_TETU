package com.example.kotlinapp_tetu.Presentation.Main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinapp_tetu.Domain.Entity.User
import com.example.kotlinapp_tetu.Domain.UseCase.CreateUserUseCase
import com.example.kotlinapp_tetu.Domain.UseCase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.kotlinapp_tetu.Presentation.Main.LoginStatus as LoginStatus1

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase)
    : ViewModel() {


    val LoginLiveData: MutableLiveData<LoginStatus1> = MutableLiveData()


    fun onClickedLogin(emailUser: String, password: String) {
        val launch = viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser, password)

            val LoginStatus = if (user != null) {
                LoginSuccess(user.email)
            } else {
                LoginError
            }
            withContext(Dispatchers.Main) {
                LoginLiveData.value = LoginStatus
            }
        }


    }
}

