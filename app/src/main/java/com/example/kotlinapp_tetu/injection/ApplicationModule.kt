package com.example.kotlinapp_tetu.injection

import android.content.Context
import androidx.room.Room
import com.example.kotlinapp_tetu.Data.Local.AppDatabase
import com.example.kotlinapp_tetu.Data.Local.DataBaseDao
import com.example.kotlinapp_tetu.Data.Repository.UserRepository
import com.example.kotlinapp_tetu.Domain.UseCase.CreateUserUseCase
import com.example.kotlinapp_tetu.Domain.UseCase.GetUserUseCase
import org.koin.dsl.module
import com.example.kotlinapp_tetu.Presentation.Main.MainViewModel
import org.koin.android.ext.koin.androidContext

val PresentationModule = module{
    factory { MainViewModel(get(), get()) }


}

val DomainModule = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val DataModule = module {
    single {UserRepository(get())}
    single <DataBaseDao> { createDataBase(androidContext()) }
}

fun createDataBase(context: Context): DataBaseDao{
    val appDatabase : AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}

