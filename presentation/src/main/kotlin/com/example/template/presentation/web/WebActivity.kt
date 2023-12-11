package com.example.template.presentation.web

import android.annotation.SuppressLint
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.activity.viewModels
import com.example.template.presentation.BR
import com.example.template.presentation.base.BaseActivity
import com.example.template.presentation.databinding.ActivityWebBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebActivity : BaseActivity<ActivityWebBinding, WebViewModel, WebEvent>(
    ActivityWebBinding::inflate,
) {

    override val viewModel: WebViewModel by viewModels()
    override fun viewModelVariableId() = BR.viewModel

    @SuppressLint("SetJavaScriptEnabled")
    override fun initViews() {
        binding.webView.webViewClient = WebViewClient()
        binding.webView.webChromeClient = WebChromeClient()
        bind {
            with(binding.webView.settings) {
                javaScriptEnabled = true
                domStorageEnabled = true
                cacheMode = WebSettings.LOAD_DEFAULT
                defaultTextEncodingName = "utf-8"
            }
        }
    }

    override fun initEventObserver(event: WebEvent) = Unit
}
