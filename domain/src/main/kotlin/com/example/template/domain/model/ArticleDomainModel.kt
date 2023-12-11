package com.example.template.domain.model

import com.example.template.data.model.ArticleDataModel

data class ArticleDomainModel(
    val id: Long,
    val title: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val isRead: Boolean,
)

fun ArticleDataModel.toDomain() = ArticleDomainModel(
    id = id,
    title = title,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    isRead = isRead,
)

fun List<ArticleDataModel>.toDomain() = map { it.toDomain() }
