package com.sultan.cleanrickandmorty.data.datasource

import com.sultan.cleanrickandmorty.data.model.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {
    @GET("character")
    suspend fun getCharacter() : CharacterDto
    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id : Int) : CharacterDto.Result
}