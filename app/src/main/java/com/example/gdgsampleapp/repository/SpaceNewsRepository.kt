package com.example.gdgsampleapp.repository

import com.example.gdgsampleapp.api.SpaceNewsApiService
import com.example.gdgsampleapp.model.SpaceNews
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SpaceNewsRepository(private val spaceNewsApiService: SpaceNewsApiService) {

    suspend fun getArticles(): List<SpaceNews> {
        return withContext(Dispatchers.IO) {
            val articlesResponse = spaceNewsApiService.getArticles()
            articlesResponse.map {
                SpaceNews(it.id, it.title, it.url, it.imageUrl, it.summary)
            }
        }
    }
}