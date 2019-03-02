package com.example.ui.di

import com.example.presentation.feature.popular.PopularContract
import com.example.presentation.feature.popular.PopularPresenter
import com.example.presentation.mapper.PopularKeywordsViewModelMapper
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

object PresentationKoinModules {
    fun modules(): List<Module> {
        return listOf(popularModule)
    }

    private val popularModule = module {
        factory {
            PopularPresenter(
                getPopularKeyWordsUseCase = get(),
                popularKeywordsViewModelMapper = get()
            ) as PopularContract.Presenter
        }
        factory {
            PopularKeywordsViewModelMapper()
        }
    }
}
