package com.example.kotlinapp_tetu.Data.Repository

import com.example.kotlinapp_tetu.Presentation.Main.Interface.RetrofitService
import com.example.kotlinapp_tetu.retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://pokeapi.co/api/v2/"

    val retrofitService : RetrofitService
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)


}