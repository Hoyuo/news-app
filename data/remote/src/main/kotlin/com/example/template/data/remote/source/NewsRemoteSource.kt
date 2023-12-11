package com.example.template.data.remote.source

import com.example.template.data.remote.model.response.Headline

/**
 * This is file template
 * Do not used in production yet
 */

interface NewsRemoteSource {
    suspend fun getTopHeadlines(): Headline
}
