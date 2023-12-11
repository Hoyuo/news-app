package com.example.template.presentation.web

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle

object WebViewActivityHelper {

    private val WebViewActivity_EXTRA_URL = "WebViewActivity_EXTRA_URL"

    fun getIntent(activity: Activity, url: String? = null): Intent {
        return Intent(activity, WebActivity::class.java).apply {
            putExtra(
                WebViewActivity_EXTRA_URL,
                url,
            )
        }
    }

    fun getUrl(intent: Intent): String {
        return intent.getStringExtra(WebViewActivity_EXTRA_URL) ?: ""
    }

    fun getUrl(savedStateHandle: SavedStateHandle): LiveData<String> {
        return savedStateHandle.getLiveData<String>(WebViewActivity_EXTRA_URL)
    }
}
