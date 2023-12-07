package com.example.template.data.remote.di

import com.example.template.data.remote.network.AccessToken
import com.example.template.data.remote.network.BaseUrl
import com.example.template.data.remote.network.ConnectTimeout
import com.example.template.data.remote.network.ReadTimeout
import com.example.template.data.remote.network.WriteTimeout
import com.example.template.data.remote.network.interceptor.AuthInterceptor
import com.example.template.data.remote.network.interceptor.HeaderInterceptor
import com.example.template.data.remote.network.interceptor.LoggingInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String {
        return "https://example.com"
    }

    @AccessToken
    @Provides
    fun provideAccessToken(): String {
        return ""
    }

    @WriteTimeout
    @Provides
    fun provideWriteTimeout(): Long {
        return 10L
    }

    @ReadTimeout
    @Provides
    fun provideReadTimeout(): Long {
        return 10L
    }

    @ConnectTimeout
    @Provides
    fun provideConnectTimeout(): Long {
        return 10L
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @WriteTimeout writeTimeout: Long,
        @ReadTimeout readTimeout: Long,
        @ConnectTimeout connectTimeout: Long,
        @LoggingInterceptor loggingInterceptor: Interceptor,
        @HeaderInterceptor headerInterceptor: Interceptor,
        @AuthInterceptor authInterceptor: Interceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .writeTimeout(writeTimeout, TimeUnit.SECONDS)
            .readTimeout(readTimeout, TimeUnit.SECONDS)
            .connectTimeout(connectTimeout, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(headerInterceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        @BaseUrl baseUrl: String,
        okHttpClient: OkHttpClient,
    ): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }
}
