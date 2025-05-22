package com.sultan.cleanrickandmorty.di

import com.sultan.cleanrickandmorty.di.data.networkModule
import com.sultan.cleanrickandmorty.di.domain.domainModule
import com.sultan.cleanrickandmorty.di.presentation.presentationModule
val appModule =
    listOf( domainModule, presentationModule, networkModule)