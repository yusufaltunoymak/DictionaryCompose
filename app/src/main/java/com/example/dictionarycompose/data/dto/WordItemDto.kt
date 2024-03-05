package com.example.dictionarycompose.data.dto


import com.google.gson.annotations.SerializedName

data class WordItemDto(
    @SerializedName("meanings")
    val meanings: List<MeaningDto>? = null,
    @SerializedName("phonetic")
    val phonetic : String? = null,
    @SerializedName("word")
    val word: String? = null
)