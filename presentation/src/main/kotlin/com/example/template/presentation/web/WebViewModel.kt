package com.example.template.presentation.web

import androidx.lifecycle.SavedStateHandle
import com.example.template.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WebViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<WebEvent>() {
    val url = WebViewActivityHelper.getUrl(savedStateHandle)
}
