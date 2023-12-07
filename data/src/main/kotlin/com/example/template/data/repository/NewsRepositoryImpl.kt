package com.example.template.data.repository

import com.example.template.data.local.source.ExampleDatabaseSource
import com.example.template.data.remote.source.NewsRemoteSource
import com.example.template.model.response.Headline
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepositoryImpl @Inject constructor(
    private val newsRemoteSource: NewsRemoteSource,
    private val exampleDatabaseSource: ExampleDatabaseSource,
//     private val exampleDataStoreSource: ExampleDataStoreSource,
) : NewsRepository {

    override fun getHeadline(): Flow<Headline> {
        return flow {
            emit(newsRemoteSource.getTopHeadlines())
        }
    }
}
