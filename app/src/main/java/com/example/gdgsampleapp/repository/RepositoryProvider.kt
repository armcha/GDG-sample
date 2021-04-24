package com.example.gdgsampleapp.repository

import com.example.gdgsampleapp.api.Api

object RepositoryProvider {

    private val spaceFlightNewsApiService by lazy {
        Api.spaceNewsApiService
    }

    val spaceNewsRepository by lazy {
        SpaceNewsRepository(spaceFlightNewsApiService)
    }
}