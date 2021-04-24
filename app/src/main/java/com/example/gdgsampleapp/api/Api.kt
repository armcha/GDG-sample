package com.example.gdgsampleapp.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Api {

    private val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://test.spaceflightnewsapi.net/api/v2/")
            .build()

    val spaceNewsApiService: SpaceNewsApiService by lazy {
        retrofit.create(SpaceNewsApiService::class.java)
    }
}