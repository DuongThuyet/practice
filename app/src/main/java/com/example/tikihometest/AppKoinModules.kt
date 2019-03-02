package com.example.tikihometest

import android.content.Context
import org.koin.dsl.module.module

object AppKoinModules {
    val appModule = module {
        single {
            App.app as Context
        }
    }
}