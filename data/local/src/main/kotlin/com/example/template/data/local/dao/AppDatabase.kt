package com.example.template.data.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.template.data.local.model.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}
