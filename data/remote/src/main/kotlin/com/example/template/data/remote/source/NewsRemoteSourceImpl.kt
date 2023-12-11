package com.example.template.data.remote.source

import com.example.template.data.remote.model.response.Headline
import com.example.template.data.remote.service.NewsService
import javax.inject.Inject

class NewsRemoteSourceImpl @Inject constructor(
    private val newsService: NewsService,
) : NewsRemoteSource {
    override suspend fun getTopHeadlines(): Headline {
        return newsService.getTopHeadlines()
    }
}
