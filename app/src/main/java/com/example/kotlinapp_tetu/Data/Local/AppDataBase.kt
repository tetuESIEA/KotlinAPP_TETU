package com.example.kotlinapp_tetu.Data.Local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinapp_tetu.Domain.Entity.User
import com.example.kotlinapp_tetu.Data.Local.Models.UserLocal

@Database(entities = arrayOf(UserLocal::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DataBaseDao
}