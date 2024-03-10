package com.example.dictionarycompose.data.mapper

import com.example.dictionarycompose.data.dto.DefinitionDto
import com.example.dictionarycompose.data.dto.MeaningDto
import com.example.dictionarycompose.data.dto.WordItemDto
import com.example.dictionarycompose.domain.model.Definition
import com.example.dictionarycompose.domain.model.Meaning
import com.example.dictionarycompose.domain.model.WordItem

fun WordItemDto.toWordItem() = WordItem (
    word = word ?: "",
    meanings = meanings?.map {
        it.toMeaning()
    } ?: emptyList(),
    phonetic = phonetic ?: ""
)

fun MeaningDto.toMeaning() = Meaning(
    definition = definitionDtoToDefinition(definitions?.get(0)),
    partOfSpeech = partOfSpeech ?: ""
)

fun definitionDtoToDefinition(definitionDto: DefinitionDto?) = Definition(
    definition = definitionDto?.definition ?: "",
    example = definitionDto?.example ?: ""
)