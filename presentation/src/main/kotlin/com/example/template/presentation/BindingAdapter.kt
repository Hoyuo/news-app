package com.example.template.presentation

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.template.presentation.main.adapter.HeadlineAdapter
import com.example.template.presentation.model.ArticleUiModel

@BindingAdapter("bind:list")
fun RecyclerView.bindList(list: List<ArticleUiModel>?) {
    (adapter as? HeadlineAdapter)?.submitList(list.orEmpty())
}

@BindingAdapter("bind:imageUrl")
fun ImageView.bindImageUrl(url: String?) {
    if (url.isNullOrEmpty()) {
        Glide.with(this)
            .clear(this)
    } else {
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(this)
    }
}
