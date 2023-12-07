package com.example.template.domain.usecase

import com.example.template.data.repository.NewsRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetHeadlineUseCase @Inject constructor(
    private val newsRepository: NewsRepository,
) {
    operator fun invoke() = newsRepository.getHeadline()
}
