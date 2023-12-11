package com.example.template.data.local.di

import com.example.template.data.local.source.AppDatabaseSource
import com.example.template.data.local.source.AppDatabaseSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSourceModule {

    @Binds
    abstract fun bindExampleDatabaseSource(
        exampleDatabaseSourceImpl: AppDatabaseSourceImpl,
    ): AppDatabaseSource
}
