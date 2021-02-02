package com.example.kotlinapp_tetu.Domain.UseCase

import android.provider.ContactsContract
import com.example.kotlinapp_tetu.Data.Repository.UserRepository
import com.example.kotlinapp_tetu.Domain.Entity.User

class GetUserUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(email: String, password: String): User? {
        return userRepository.GetUser(email)
    }
}