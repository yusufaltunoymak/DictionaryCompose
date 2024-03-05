package com.example.dictionarycompose.data.dto


import com.google.gson.annotations.SerializedName

data class License(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)