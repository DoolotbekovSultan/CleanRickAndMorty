package com.sultan.cleanrickandmorty.presentation.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultan.cleanrickandmorty.domain.model.Character
import com.sultan.cleanrickandmorty.domain.usecases.GetCharacterByIdUseCase
import com.sultan.cleanrickandmorty.util.Either
import com.sultan.cleanrickandmorty.util.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect


class DetailViewModel (
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase
) : ViewModel() {

    private val _resultState = MutableStateFlow<UIState<Character.Result>>(UIState.Empty())
    val resultState = _resultState.asStateFlow()

    fun getCharacterById(id : Int) {
        viewModelScope.launch {
            getCharacterByIdUseCase.invoke(id).collect { data ->
                _resultState.value = UIState.Loading()
                when (data) {
                    is Either.Left -> {
                        _resultState.value = UIState.Error(data.value)
                    }
                    is Either.Right -> {
                        _resultState.value = UIState.Success(data.value)
                    }
                }

            }
        }
    }

}