package com.example.template.domain.usecase

import com.example.template.data.repository.NewsRepository
import com.example.template.domain.model.ArticleDomainModel
import dagger.Reusable
import javax.inject.Inject
import timber.log.Timber

@Reusable
class SetReadArticleUseCase @Inject constructor(
    private val newsRepository: NewsRepository,
) {
    suspend operator fun invoke(articleDomainModel: ArticleDomainModel) {
        if (articleDomainModel.isRead) {
            Timber.d("Article is already read")
            return
        }
        if (articleDomainModel.id == 0L) {
            Timber.w("Article id is 0")
            return
        }
        newsRepository.setReadArticle(articleDomainModel.id)
    }
}
