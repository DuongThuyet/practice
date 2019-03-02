package com.example.ui.di

import com.example.domain.usecase.GetPopularKeyWordsUseCase
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

object DomainKoinModules {
    fun modules(): List<Module> {
        return listOf(popularModule)
    }

    private val popularModule = module {
        factory {
            GetPopularKeyWordsUseCase(
                appRepository = get(),
               useCaseExecution = get()
            )
        }
    }
}