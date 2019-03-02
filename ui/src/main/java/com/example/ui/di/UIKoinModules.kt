package com.example.ui.di

import com.billandbros.metrip.ui.base.executor.AndroidUseCaseExecution
import com.example.domain.usecase.base.UseCaseExecution
import com.example.ui.adapter.RecyclerViewAdapter
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

object UIKoinModules {
    fun modules(): List<Module> {
        return listOf(uiModule, popularModule)
    }

    private val popularModule = module {
        factory {
            RecyclerViewAdapter()
        }
    }
    private val uiModule = module {
        single {
            AndroidUseCaseExecution() as UseCaseExecution
        }


    }
}