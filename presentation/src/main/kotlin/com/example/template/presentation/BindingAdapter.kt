package com.example.template.presentation

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.template.presentation.main.adapter.HeadlineAdapter
import com.example.template.presentation.model.ArticleUiModel

@BindingAdapter("bind:list")
fun RecyclerView.bindList(list: List<ArticleUiModel>?) {
    (adapter as? HeadlineAdapter)?.submitList(list.orEmpty())
}

@BindingAdapter("bind:imageUrl")
fun ImageView.bindImageUrl(url: String?) {
    url?.let {
        Glide.with(this)
            .load(it)
            .into(this)
    }
}
