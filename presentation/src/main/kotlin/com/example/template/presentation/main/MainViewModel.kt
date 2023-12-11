package com.example.template.presentation.main

import androidx.lifecycle.viewModelScope
import com.example.template.domain.usecase.GetArticleListUseCase
import com.example.template.domain.usecase.SetReadArticleUseCase
import com.example.template.presentation.base.BaseViewModel
import com.example.template.presentation.model.ArticleUiModel
import com.example.template.presentation.model.toDomainModel
import com.example.template.presentation.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getArticleListUseCase: GetArticleListUseCase,
    private val setReadArticleUseCase: SetReadArticleUseCase,
) : BaseViewModel<MainEvent>() {

    private val _articles = MutableStateFlow(emptyList<ArticleUiModel>())
    val articles = _articles.asStateFlow()

    init {
        getArticleList()
    }

    fun getArticleList() {
        getArticleListUseCase()
            .map {
                it.toUiModel()
            }
            .onEach {
                _articles.value = it
            }
            .launchIn(viewModelScope)
    }

    fun onArticleClicked(articleUiModel: ArticleUiModel) {
        setReadArticle(articleUiModel)
    }

    private fun setReadArticle(articleUiModel: ArticleUiModel) {
        viewModelScope.launch {
            setReadArticleUseCase(articleUiModel.toDomainModel())
        }

        sendEvent(MainEvent.NavigateToWeb(articleUiModel.url))
    }
}
