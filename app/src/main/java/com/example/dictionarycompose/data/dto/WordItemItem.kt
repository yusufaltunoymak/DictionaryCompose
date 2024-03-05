package com.example.dictionarycompose.data.dto


import com.google.gson.annotations.SerializedName

data class WordItemItem(
    @SerializedName("license")
    val license: License?,
    @SerializedName("meanings")
    val meanings: List<Meaning>?,
    @SerializedName("phonetics")
    val phonetics: List<Phonetic>?,
    @SerializedName("sourceUrls")
    val sourceUrls: List<String>?,
    @SerializedName("word")
    val word: String?
)