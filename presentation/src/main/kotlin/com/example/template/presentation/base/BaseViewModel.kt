package com.example.template.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<E : BaseEvent> : ViewModel() {

    private val _viewEvent: MutableStateFlow<E?> = MutableStateFlow(null)
    val viewEvent = _viewEvent.asStateFlow()

    protected fun sendEvent(event: E) {
        _viewEvent.value = event
    }

    fun clearEvent() {
        _viewEvent.value = null
    }
}
