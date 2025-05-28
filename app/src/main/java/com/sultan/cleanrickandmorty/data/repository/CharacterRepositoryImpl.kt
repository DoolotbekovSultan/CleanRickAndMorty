package com.sultan.cleanrickandmorty.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.sultan.cleanrickandmorty.data.datasource.CharacterService
import com.sultan.cleanrickandmorty.data.mapper.toCharacter
import com.sultan.cleanrickandmorty.data.mapper.toResult
import com.sultan.cleanrickandmorty.domain.model.Character
import com.sultan.cleanrickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import okio.IOException

class CharacterRepositoryImpl (
    private val service : CharacterService
) : CharacterRepository {
    override suspend fun getCharacter() : LiveData<Character> = liveData(Dispatchers.IO) {
        try {
            val response = service.getCharacter()
            emit(response.toCharacter())
        } catch (e : IOException) {
            Log.e("exception", "getCharacter: ${e.localizedMessage}")
        }
    }

    override suspend fun getCharacterById(id : Int) : LiveData<Character.Result> = liveData(Dispatchers.IO) {
        try {
            val response = service.getCharacterById(id)
            emit(response.toResult())
        } catch (e : IOException) {
            Log.e("exception", "getCharacterById: ${e.localizedMessage}")
        }
    }
}