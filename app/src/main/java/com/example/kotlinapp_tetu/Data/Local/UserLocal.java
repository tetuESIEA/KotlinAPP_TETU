package com.example.kotlinapp_tetu.Data.Local;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
data class UserLocal(@ColumnInfo(name = "email") val email: String?){

    @PrimaryKey(autoGenerate = true) val uid:Int?=null
}

        fun User.toData(): UserLocal{
            return UserLocal(email = email)
        }

        fun UserLocal.toEntity(): User{
            return User(email = email)
        }
