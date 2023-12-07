package com.example.template.data.local.di

import com.example.template.data.local.source.ExampleDataStoreSource
import com.example.template.data.local.source.ExampleDataStoreSourceImpl
import com.example.template.data.local.source.ExampleDatabaseSource
import com.example.template.data.local.source.ExampleDatabaseSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSourceModule {

    @Binds
    abstract fun bindExampleDatabaseSource(
        exampleDatabaseSourceImpl: ExampleDatabaseSourceImpl,
    ): ExampleDatabaseSource

    @Binds
    abstract fun bindExampleDataStoreSource(
        exampleDataStoreSourceImpl: ExampleDataStoreSourceImpl,
    ): ExampleDataStoreSource
}
