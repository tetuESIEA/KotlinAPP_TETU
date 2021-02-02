package com.example.kotlinapp_tetu.Domain.UseCase

import com.example.kotlinapp_tetu.Data.Repository.UserRepository
import com.example.kotlinapp_tetu.Domain.Entity.User

class CreateUserUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(user: User){
        userRepository.CreateUser(user)
    }
}