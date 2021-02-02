package com.example.kotlinapp_tetu.Presentation.Main.Interface

import com.example.kotlinapp_tetu.Data.Local.Model.Pokemon
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("pokemon")
    fun getPokemonList() : Call<MutableList<Pokemon>>
}