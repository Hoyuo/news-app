package com.example.template.data.local.di

import android.content.Context
import androidx.room.Room
import com.example.template.data.local.dao.ExampleDao
import com.example.template.data.local.dao.ExampleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(
        @ApplicationContext context: Context,
    ): ExampleDatabase {
        return Room
            .databaseBuilder(context, ExampleDatabase::class.java, "example.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideExampleDao(
        database: ExampleDatabase,
    ): ExampleDao {
        return database.exampleDao()
    }
}
