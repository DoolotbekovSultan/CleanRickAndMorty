package com.sultan.cleanrickandmorty.data.datasource

import com.sultan.cleanrickandmorty.data.model.CharacterDto
import retrofit2.http.GET

interface CharacterService {
    @GET("character")
    suspend fun getCharacter() : CharacterDto
}