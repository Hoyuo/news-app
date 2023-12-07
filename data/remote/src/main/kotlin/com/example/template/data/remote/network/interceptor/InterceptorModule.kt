package com.example.template.data.remote.network.interceptor

import com.example.template.data.remote.network.ApiKey
import com.example.template.data.remote.network.CountryCode
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

@Module
@InstallIn(SingletonComponent::class)
object InterceptorModule {

    @LoggingInterceptor
    @Provides
    fun provideLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @AuthInterceptor
    @Provides
    fun provideAuthInterceptor(
        @ApiKey apikey: String,
        @CountryCode countryCode: String,
    ): Interceptor {
        return Interceptor { chain ->
            val url = chain.request().url.newBuilder()
                .addQueryParameter("apiKey", apikey)
                .addQueryParameter("country", countryCode)
                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            chain.proceed(request)
        }
    }
}
