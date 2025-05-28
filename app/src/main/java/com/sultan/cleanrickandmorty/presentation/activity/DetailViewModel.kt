package com.sultan.cleanrickandmorty.presentation.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultan.cleanrickandmorty.domain.model.Character
import com.sultan.cleanrickandmorty.domain.usecases.GetCharacterByIdUseCase
import kotlinx.coroutines.launch

class DetailViewModel (
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase
) : ViewModel() {

    private val _result = MutableLiveData<Character.Result>()
    val result : LiveData<Character.Result> = _result

    fun getCharacterById(id : Int) {
        viewModelScope.launch {
            getCharacterByIdUseCase.invoke(id).observeForever { data ->
                _result.postValue(data)
            }
        }
    }

}