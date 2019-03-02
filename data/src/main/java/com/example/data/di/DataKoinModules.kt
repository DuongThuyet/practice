package com.example.data.di

import com.example.data.remote.ApiServiceApp
import com.example.data.repositoryimpl.AppRepositoryImpl
import com.example.domain.repository.AppRepository
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object DataKoinModules {
    fun modules(): List<Module> {
        return listOf(remoteModuleApp, popularModule)
    }

    private val remoteModuleApp = module {
        fun createApiServiceApp(): ApiServiceApp {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(ApiServiceApp::class.java)
        }

        single {
            createApiServiceApp()
        }
    }

    private val popularModule = module {
        single {
            AppRepositoryImpl(apiServiceApp = get()) as AppRepository
        }
    }


}