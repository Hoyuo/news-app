package com.example.template.data.remote.service

import com.example.template.model.response.Headline
import retrofit2.http.GET

interface NewsService {

    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(): Headline
}
