package com.example.template.data.local.source

import com.example.template.data.local.dao.ArticleDao
import com.example.template.data.local.model.ArticleEntity
import javax.inject.Inject

class AppDatabaseSourceImpl @Inject constructor(
    private val articleDao: ArticleDao,
) : AppDatabaseSource {

    override fun getList() = articleDao.getList()

    override suspend fun getAll(): List<ArticleEntity> = articleDao.getAll()

    override suspend fun get(id: Int): ArticleEntity = articleDao.get(id)

    override suspend fun insert(entity: ArticleEntity) {
        articleDao.insert(entity)
    }

    override suspend fun insert(entityList: List<ArticleEntity>) {
        articleDao.insert(entityList)
    }

    override suspend fun update(entity: ArticleEntity) {
        articleDao.update(entity)
    }

    override suspend fun replaceAll(entityList: List<ArticleEntity>) {
        articleDao.replaceAll(entityList)
    }

    override suspend fun delete(entity: ArticleEntity) {
        articleDao.delete(entity)
    }

    override suspend fun deleteAll() {
        articleDao.deleteAll()
    }

    override suspend fun setReadArticle(id: Long) {
        articleDao.setReadArticle(id)
    }
}
