package com.sultan.cleanrickandmorty.data.repository

import com.sultan.cleanrickandmorty.data.datasource.CharacterService
import com.sultan.cleanrickandmorty.data.mapper.toCharacter
import com.sultan.cleanrickandmorty.domain.repository.CharacterRepository

class CharacterRepositoryImpl (
    private val service : CharacterService
) : CharacterRepository {
    override suspend fun getCharacter() = service.getCharacter().toCharacter()

}