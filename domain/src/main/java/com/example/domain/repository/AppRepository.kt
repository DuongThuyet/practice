package com.example.domain.repository

import io.reactivex.Single

interface AppRepository {
    fun getPopularKeywords(): Single<List<String?>?>
}