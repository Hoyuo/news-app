package com.example.template.presentation.model

import androidx.recyclerview.widget.DiffUtil
import com.example.template.domain.model.ArticleDomainModel
import java.time.ZonedDateTime
import java.util.Date

data class ArticleUiModel(
    val id: Long,
    val title: String,
    val url: String,
    val urlToImage: String,
    val _publishedAt: String,
    val isRead: Boolean,
) {
    val publishedAt: Date
        get() = ZonedDateTime.parse(_publishedAt).toInstant().let { Date.from(it) }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ArticleUiModel>() {
            override fun areItemsTheSame(
                oldItem: ArticleUiModel,
                newItem: ArticleUiModel,
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ArticleUiModel,
                newItem: ArticleUiModel,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}

fun ArticleDomainModel.toUiModel() = ArticleUiModel(
    id = id,
    title = title ?: "",
    url = url ?: "",
    urlToImage = urlToImage ?: "",
    _publishedAt = publishedAt ?: "",
    isRead = isRead,
)

fun List<ArticleDomainModel>.toUiModel() = map { it.toUiModel() }

fun ArticleUiModel.toDomainModel() = ArticleDomainModel(
    id = id,
    title = title,
    url = url,
    urlToImage = urlToImage,
    publishedAt = _publishedAt,
    isRead = isRead,
)

fun List<ArticleUiModel>.toDomainModel() = map { it.toDomainModel() }
