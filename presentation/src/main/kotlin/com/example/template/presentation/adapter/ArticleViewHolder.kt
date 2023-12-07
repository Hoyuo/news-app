package com.example.template.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.template.model.response.Article
import com.example.template.presentation.databinding.ItemArticleBinding

class ArticleViewHolder(
    private val binding: ItemArticleBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article) {
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
