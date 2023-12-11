package com.example.template.presentation.web

import android.webkit.WebView
import androidx.databinding.BindingAdapter

@BindingAdapter("bind:webView")
fun WebView.bindWebView(url: String?) {
    url?.let {
        loadUrl(it)
    }
}
