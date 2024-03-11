package com.example.dictionarycompose.presentation

import com.example.dictionarycompose.domain.model.WordItem

data class MainState(
    val isLoading : Boolean = false,
    val searchWord : String = "",
    val wordItem : WordItem? = null
)
