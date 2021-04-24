package com.example.gdgsampleapp.api

import com.example.gdgsampleapp.model.SpaceNewsResponse
import retrofit2.http.GET

interface SpaceNewsApiService {

    @GET("articles")
    suspend fun getArticles(): List<SpaceNewsResponse>

}