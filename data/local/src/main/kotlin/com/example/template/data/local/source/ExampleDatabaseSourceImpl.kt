package com.example.template.data.local.source

import com.example.template.data.local.dao.ExampleDao
import com.example.template.model.entity.ExampleEntity
import javax.inject.Inject

class ExampleDatabaseSourceImpl @Inject constructor(
    private val exampleDao: ExampleDao,
) : ExampleDatabaseSource {
    override suspend fun getAll(): List<ExampleEntity> {
        return exampleDao.getAll()
    }

    override suspend fun insert(example: ExampleEntity) {
        exampleDao.insert(example)
    }

    override suspend fun update(example: ExampleEntity) {
        exampleDao.update(example)
    }

    override suspend fun delete(example: ExampleEntity) {
        exampleDao.delete(example)
    }
}
