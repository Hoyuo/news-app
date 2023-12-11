package com.example.template.data.repository

import com.example.template.data.local.source.AppDatabaseSource
import com.example.template.data.model.ArticleDataModel
import com.example.template.data.model.toDataModel
import com.example.template.data.model.toEntity
import com.example.template.data.remote.source.NewsRemoteSource
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepositoryImpl @Inject constructor(
    private val newsRemoteSource: NewsRemoteSource,
    private val appDatabaseSource: AppDatabaseSource,
) : NewsRepository {

    override fun getArticleList(): Flow<List<ArticleDataModel>> {
        return flow {
            runCatching { newsRemoteSource.getTopHeadlines() }
                .map {
                    it.articles.toDataModel()
                }
                .fold(
                    onSuccess = {
                        val listLocal = appDatabaseSource.getAll()
                        it.map { list ->
                            list.isRead = listLocal.find { local -> local.id == list.id }?.isRead
                                ?: false
                        }
                        appDatabaseSource.replaceAll(it.toEntity())
                        it
                    },
                    onFailure = {
                        appDatabaseSource.getAll().toDataModel()
                    },
                )
                .let {
                    emit(it)
                }
        }
    }

    override suspend fun setReadArticle(id: Long) {
        appDatabaseSource.setReadArticle(id)
    }
}
