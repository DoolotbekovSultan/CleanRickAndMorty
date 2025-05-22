package com.sultan.cleanrickandmorty.domain.usecases

import com.sultan.cleanrickandmorty.domain.repository.CharacterRepository

class GetCharacterUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke() = repository.getCharacter()
}