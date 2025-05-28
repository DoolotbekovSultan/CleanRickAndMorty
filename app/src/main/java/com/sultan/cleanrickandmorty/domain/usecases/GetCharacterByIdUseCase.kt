package com.sultan.cleanrickandmorty.domain.usecases

import com.sultan.cleanrickandmorty.domain.repository.CharacterRepository

class GetCharacterByIdUseCase (
    private val repository : CharacterRepository
) {
    suspend operator fun invoke(id : Int) = repository.getCharacterById(id)
}