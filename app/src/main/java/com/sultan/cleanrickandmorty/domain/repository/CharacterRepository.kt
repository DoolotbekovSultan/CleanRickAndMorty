package com.sultan.cleanrickandmorty.domain.repository

import androidx.lifecycle.LiveData
import com.sultan.cleanrickandmorty.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacter() : LiveData<Character>
    suspend fun getCharacterById(id : Int) : LiveData<Character.Result>
}