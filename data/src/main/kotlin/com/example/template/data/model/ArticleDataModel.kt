package com.example.template.data.model

import com.example.template.data.local.model.ArticleEntity
import com.example.template.data.remote.model.response.Article
import java.text.SimpleDateFormat

data class ArticleDataModel(
    val title: String?,
    val publishedAt: String?,
    val url: String?,
    val urlToImage: String?,
    var isRead: Boolean = false,
) {
    var id: Long = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        .parse(publishedAt ?: "")?.time ?: 0L
}

fun Article.toDataModel() = ArticleDataModel(
    title = title,
    url = url,
    publishedAt = publishedAt,
    urlToImage = urlToImage,
)

@JvmName("toDataModelArticle")
fun List<Article>.toDataModel() = map { it.toDataModel() }

fun ArticleDataModel.toEntity() = ArticleEntity(
    id = id,
    title = title,
    publishedAt = publishedAt,
    url = url,
    urlToImage = urlToImage,
    isRead = isRead,
)

fun List<ArticleDataModel>.toEntity() = map { it.toEntity() }

fun ArticleEntity.toDataModel() = ArticleDataModel(
    title = title,
    publishedAt = publishedAt,
    url = url,
    urlToImage = urlToImage,
    isRead = isRead,
)

@JvmName("toDataModelArticleEntity")
fun List<ArticleEntity>.toDataModel() = map { it.toDataModel() }
