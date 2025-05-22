package com.sultan.cleanrickandmorty.data.mapper

import com.sultan.cleanrickandmorty.data.model.CharacterDto
import com.sultan.cleanrickandmorty.domain.model.Character

fun CharacterDto.toCharacter() : Character = Character (
    results = this.results.map { it.toResult() }
)

fun CharacterDto.Result.toResult() : Character.Result = Character.Result(
    image = this.image,
    name = this.name
)