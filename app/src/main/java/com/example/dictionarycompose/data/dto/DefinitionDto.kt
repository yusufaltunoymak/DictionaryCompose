package com.example.dictionarycompose.data.dto


import com.google.gson.annotations.SerializedName

data class DefinitionDto(
    @SerializedName("definition")
    val definition: String? = null,
    @SerializedName("example")
    val example: String? = null
)