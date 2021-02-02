package com.example.kotlinapp_tetu.Data.Repository

import com.example.kotlinapp_tetu.Data.Local.DataBaseDao
import com.example.kotlinapp_tetu.Domain.Entity.User

class UserRepository(private val databaseDao: DataBaseDao) {
        suspend fun CreateUser(user: User){
                databaseDao.insert(user.toData())

        }
        fun GetUser(email: String): User?{
                val UserLocal = databaseDao.findByName(email)
                return userLocal?.toEntity()
        }


}