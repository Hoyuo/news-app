package com.example.template.data.local.di

import android.content.Context
import androidx.room.Room
import com.example.template.data.local.dao.AppDatabase
import com.example.template.data.local.dao.ArticleDao
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
    ): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "app_database.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideExampleDao(
        database: AppDatabase,
    ): ArticleDao {
        return database.articleDao()
    }
}
