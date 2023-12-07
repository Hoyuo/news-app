package com.example.template.data.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.template.model.entity.ExampleEntity

@Database(entities = [ExampleEntity::class], version = 1, exportSchema = false)
abstract class ExampleDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao
}
