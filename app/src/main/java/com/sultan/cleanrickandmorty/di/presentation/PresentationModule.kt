package com.sultan.cleanrickandmorty.di.presentation

import com.sultan.cleanrickandmorty.presentation.activity.DetailViewModel
import com.sultan.cleanrickandmorty.presentation.activity.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        MainViewModel(
            getCharacterUseCase = get()
        )
    }
    viewModel {
        DetailViewModel(
            getCharacterByIdUseCase = get()
        )
    }
}