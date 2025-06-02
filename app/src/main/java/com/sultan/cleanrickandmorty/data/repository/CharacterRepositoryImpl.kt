package com.sultan.cleanrickandmorty.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.sultan.cleanrickandmorty.data.datasource.CharacterService
import com.sultan.cleanrickandmorty.data.mapper.toCharacter
import com.sultan.cleanrickandmorty.data.mapper.toResult
import com.sultan.cleanrickandmorty.domain.model.Character
import com.sultan.cleanrickandmorty.domain.repository.CharacterRepository
import com.sultan.cleanrickandmorty.util.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okio.IOException

class CharacterRepositoryImpl (
    private val service : CharacterService
) : CharacterRepository {
    override suspend fun getCharacter() : Flow<Either<String, Character>> = flow {
        try {
            val response = service.getCharacter()
            emit(Either.Right(response.toCharacter()))
        } catch (e : IOException) {
            emit(Either.Left(e.localizedMessage ?: "Unknown error!"))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getCharacterById(id : Int) : Flow<Either<String, Character.Result>> = flow {
        try {
            val response = service.getCharacterById(id)
            emit(Either.Right(response.toResult()))
        } catch (e : IOException) {
            emit(Either.Left(e.localizedMessage ?: "Unknown error!"))
        }
    }.flowOn(Dispatchers.IO)
}