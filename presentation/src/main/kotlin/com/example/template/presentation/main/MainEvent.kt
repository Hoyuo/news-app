package com.example.template.presentation.main

import com.example.template.presentation.base.BaseEvent

sealed interface MainEvent : BaseEvent {
    data class NavigateToWeb(val url: String) : MainEvent
}
