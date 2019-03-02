package com.example.tikihometest

import android.app.Application
import android.content.Context
import com.example.data.di.DataKoinModules
import com.example.ui.di.DomainKoinModules
import com.example.ui.di.PresentationKoinModules
import com.example.ui.di.UIKoinModules
import org.koin.dsl.module.Module
import org.koin.standalone.StandAloneContext

class App : Application() {

    companion object {
        @JvmStatic
        lateinit var app: App
    }
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        initKoinDI()
    }

    private fun initKoinDI() {
        val modules: MutableList<Module> = mutableListOf()
        modules.add(AppKoinModules.appModule)
        modules.addAll(UIKoinModules.modules())
        modules.addAll(PresentationKoinModules.modules())
        modules.addAll(DomainKoinModules.modules())
        modules.addAll(DataKoinModules.modules())
        StandAloneContext.startKoin(modules)
    }
}