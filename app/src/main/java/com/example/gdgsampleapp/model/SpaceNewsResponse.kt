package com.example.gdgsampleapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpaceNewsResponse(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "url") val url: String,
    @field:Json(name = "imageUrl") val imageUrl: String,
    @field:Json(name = "summary") val summary: String,
)