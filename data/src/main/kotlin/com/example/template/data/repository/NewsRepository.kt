package com.example.template.data.repository

import com.example.template.model.response.Headline
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getHeadline(): Flow<Headline>
}
