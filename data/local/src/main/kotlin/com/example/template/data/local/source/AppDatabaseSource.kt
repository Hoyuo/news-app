package com.example.template.data.local.source

import com.example.template.data.local.model.ArticleEntity
import kotlinx.coroutines.flow.Flow

interface AppDatabaseSource {
    fun getList(): Flow<List<ArticleEntity>>
    suspend fun getAll(): List<ArticleEntity>
    suspend fun get(id: Int): ArticleEntity
    suspend fun insert(entity: ArticleEntity)
    suspend fun insert(entityList: List<ArticleEntity>)
    suspend fun update(entity: ArticleEntity)
    suspend fun replaceAll(entityList: List<ArticleEntity>)
    suspend fun delete(entity: ArticleEntity)
    suspend fun deleteAll()
    suspend fun setReadArticle(id: Long)
}
