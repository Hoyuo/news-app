package com.example.template.presentation.main

import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.template.presentation.R
import com.example.template.presentation.model.ArticleUiModel
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date

@BindingAdapter("bind:title")
fun TextView.bindTitle(articleUiModel: ArticleUiModel) {
    setTextColor(
        if (articleUiModel.isRead) {
            ContextCompat.getColorStateList(context, R.color.color_read)
        } else {
            ContextCompat.getColorStateList(context, R.color.color_unread)
        },
    )
    text = articleUiModel.title
}

@BindingAdapter("bind:publishedAt")
fun TextView.bindPublishedAt(publishedAt: Date) {
    val timeZone = ZoneId.systemDefault()
    val format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    text = publishedAt.toInstant().atZone(timeZone).toLocalDateTime().format(format)
}
