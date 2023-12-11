package com.example.template.data.repository

import com.example.template.data.model.ArticleDataModel
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getArticleList(): Flow<List<ArticleDataModel>>

    suspend fun setReadArticle(id: Long)
}
