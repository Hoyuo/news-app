package com.example.template.domain.usecase

import com.example.template.data.repository.NewsRepository
import com.example.template.domain.model.toDomain
import dagger.Reusable
import javax.inject.Inject
import kotlinx.coroutines.flow.map

@Reusable
class GetArticleListUseCase @Inject constructor(
    private val newsRepository: NewsRepository,
) {
    operator fun invoke() = newsRepository.getArticleList()
        .map {
            it.sortedByDescending { it.id }
                .toDomain()
        }
}
