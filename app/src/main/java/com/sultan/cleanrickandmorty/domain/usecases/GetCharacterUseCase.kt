package com.sultan.cleanrickandmorty.domain.usecases

import com.sultan.cleanrickandmorty.domain.model.Character
import com.sultan.cleanrickandmorty.domain.repository.CharacterRepository
import com.sultan.cleanrickandmorty.util.Either
import kotlinx.coroutines.flow.Flow

class GetCharacterUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke() : Flow<Either<String, Character>> = repository.getCharacter()
}