package com.example.kotlinapp_tetu.Data.Local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlinapp_tetu.Data.Local.Models.UserLocal
import com.example.kotlinapp_tetu.Data.Local.UserLocal as UserLocal

@Dao
interface DataBaseDao {
    @Query("SELECT * FROM userLocal")
    fun getAll(): List<UserLocal>

    @Query("SELECT * FROM userLocal WHERE email LIKE: email LIMIT 1")
    fun findByName(email: String): UserLocal?

    @Insert
    fun insert(users: UserLocal)

    @Delete
    fun delete(user: UserLocal)
}