package com.example.template.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.template.data.local.model.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article")
    suspend fun getAll(): List<ArticleEntity>

    @Query("SELECT * FROM article")
    fun getList(): Flow<List<ArticleEntity>>

    @Query("SELECT * FROM article WHERE id = :id")
    suspend fun get(id: Int): ArticleEntity

    @Insert
    suspend fun insert(entity: ArticleEntity)

    @Insert
    suspend fun insert(entity: List<ArticleEntity>)

    @Update
    suspend fun update(entity: ArticleEntity)

    @Transaction
    suspend fun replaceAll(entityList: List<ArticleEntity>) {
        deleteAll()
        insert(entityList)
    }

    @Query("UPDATE article SET isRead = 1 WHERE id = :id")
    suspend fun setReadArticle(id: Long)

    @Delete
    suspend fun delete(entity: ArticleEntity)

    @Query("DELETE FROM article")
    suspend fun deleteAll()
}
