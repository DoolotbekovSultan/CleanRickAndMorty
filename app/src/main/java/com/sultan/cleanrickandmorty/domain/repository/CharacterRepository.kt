package com.sultan.cleanrickandmorty.domain.repository

import com.sultan.cleanrickandmorty.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacter() : Character
}