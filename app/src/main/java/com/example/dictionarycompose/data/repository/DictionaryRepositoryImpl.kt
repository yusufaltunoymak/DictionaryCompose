package com.example.dictionarycompose.data.repository

import android.app.Application
import com.example.dictionarycompose.R
import com.example.dictionarycompose.data.mapper.toWordItem
import com.example.dictionarycompose.data.remote.DictionaryApi
import com.example.dictionarycompose.domain.model.WordItem
import com.example.dictionarycompose.domain.repository.DictionaryRepository
import com.example.dictionarycompose.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DictionaryRepositoryImpl @Inject constructor(
    val dictionaryApi : DictionaryApi,
    private val application : Application
) : DictionaryRepository {
    override suspend fun getWordResult(word: String): Flow<Response<WordItem>> {
        return flow {
            emit(Response.Loading())
            val remoteWordResultDto = try {
                dictionaryApi.getWordResult(word = word)
            }
            catch (e : HttpException) {
                e.printStackTrace()
                emit(Response.Error(message = application.getString(R.string.can_t_get_result_text)))
                return@flow
            }
            catch (e : IOException) {
                e.printStackTrace()
                emit(Response.Error(message = application.getString(R.string.can_t_get_result_text)))
                return@flow
            }
            catch (e : Exception) {
                e.printStackTrace()
                emit(Response.Error(message = application.getString(R.string.can_t_get_result_text)))
                return@flow
            }
            remoteWordResultDto?.let {
                it[0]?.let { wordItemDto ->
                    emit(Response.Success(data = wordItemDto.toWordItem()))
                    return@flow
                }
            }
            emit(Response.Error(message = application.getString(R.string.can_t_get_result_text)))
        }
    }
}