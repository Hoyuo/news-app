package com.example.template.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.template.presentation.databinding.ItemArticleBinding
import com.example.template.presentation.model.ArticleUiModel

class ArticleViewHolder(
    private val binding: ItemArticleBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: ArticleUiModel) {
        binding.data = article
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): ArticleViewHolder {
            return ArticleViewHolder(
                ItemArticleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false,
                ),
            )
        }
    }
}
