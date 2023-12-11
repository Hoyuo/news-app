package com.example.template.presentation.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.template.presentation.model.ArticleUiModel

class HeadlineAdapter(
    private val onClick: (ArticleUiModel) -> Unit,
) : ListAdapter<ArticleUiModel, ArticleViewHolder>(ArticleUiModel.diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }
}
