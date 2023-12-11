package com.example.template.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class ArticleEntity(
    @PrimaryKey
    val id: Long = 0,
    val title: String?,
    val publishedAt: String?,
    val url: String?,
    val urlToImage: String?,
    val isRead: Boolean = false,
)
