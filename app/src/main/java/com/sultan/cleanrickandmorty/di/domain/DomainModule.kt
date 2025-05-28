package com.sultan.cleanrickandmorty.di.domain

import com.sultan.cleanrickandmorty.domain.usecases.GetCharacterByIdUseCase
import com.sultan.cleanrickandmorty.domain.usecases.GetCharacterUseCase
import org.koin.dsl.module

val domainModule = module {
    single {
        GetCharacterUseCase(repository = get())
    }
    single {
        GetCharacterByIdUseCase(repository = get())
    }
}