package com.example.template.data.remote.source

import com.example.template.data.remote.service.NewsService
import com.example.template.model.response.Headline
import javax.inject.Inject

class NewsRemoteSourceImpl @Inject constructor(
    private val newsService: NewsService,
) : NewsRemoteSource {
    override suspend fun getTopHeadlines(): Headline {
        return newsService.getTopHeadlines()
    }
}
