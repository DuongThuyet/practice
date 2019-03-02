package com.example.data.remote

import io.reactivex.Single
import retrofit2.http.GET

interface ApiServiceApp {
    //Get value
    @GET("/tikivn/android-home-test/v2/keywords.json")
    fun getData(): Single<List<String?>?>

}