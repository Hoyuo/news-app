package com.example.template.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.template.model.response.Article

class HeadlineAdapter(
    private var list: MutableList<Article> = mutableListOf(),
    private val onClick: (Article) -> Unit,
) : RecyclerView.Adapter<ArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            onClick(list[position])
        }
    }

    override fun getItemCount(): Int = list.size

    fun submitList(list: List<Article>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}
