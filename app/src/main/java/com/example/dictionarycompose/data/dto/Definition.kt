package com.example.dictionarycompose.data.dto


import com.google.gson.annotations.SerializedName

data class Definition(
    @SerializedName("antonyms")
    val antonyms: List<Any?>?,
    @SerializedName("definition")
    val definition: String?,
    @SerializedName("example")
    val example: String?,
    @SerializedName("synonyms")
    val synonyms: List<Any?>?
)