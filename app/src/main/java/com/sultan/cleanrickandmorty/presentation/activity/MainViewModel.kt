package com.sultan.cleanrickandmorty.presentation.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultan.cleanrickandmorty.domain.model.Character
import com.sultan.cleanrickandmorty.domain.usecases.GetCharacterUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {

    private val _character = MutableLiveData<Character?>()
    val character : LiveData<Character?> = _character

    fun getCharacter() {
        viewModelScope.launch {
            getCharacterUseCase.invoke().observeForever { data ->
                _character.postValue(data)
            }
        }
    }
}