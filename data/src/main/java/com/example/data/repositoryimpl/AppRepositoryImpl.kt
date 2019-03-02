package com.example.data.repositoryimpl

import com.example.data.remote.ApiServiceApp
import com.example.domain.repository.AppRepository
import io.reactivex.Single

class AppRepositoryImpl(private val apiServiceApp: ApiServiceApp) : AppRepository {
    override fun getPopularKeywords(): Single<List<String?>?> {
        return apiServiceApp.getData()
    }
}