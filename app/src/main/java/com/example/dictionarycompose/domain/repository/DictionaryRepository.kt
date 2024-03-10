package com.example.dictionarycompose.domain.repository

import com.example.dictionarycompose.domain.model.WordItem
import com.example.dictionarycompose.util.Response
import kotlinx.coroutines.flow.Flow

interface DictionaryRepository {
    suspend fun getWordResult(word : String) : Flow<Response<WordItem>>
}