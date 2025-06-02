package com.sultan.cleanrickandmorty.domain.repository

import com.sultan.cleanrickandmorty.domain.model.Character
import com.sultan.cleanrickandmorty.util.Either
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharacter() : Flow<Either<String, Character>>
    suspend fun getCharacterById(id : Int) : Flow<Either<String, Character.Result>>
}