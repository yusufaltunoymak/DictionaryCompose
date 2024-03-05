package com.example.dictionarycompose.data.remote

import com.example.dictionarycompose.data.dto.WordResultDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {
    //https://api.dictionaryapi.dev/api/v2/entries/en/<word>
    @GET("{word}")
    suspend fun getWordResult(
        @Path("word") word : String
    ) : WordResultDto

    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/"
    }

}