package com.example.dictionarycompose.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionarycompose.domain.repository.DictionaryRepository
import com.example.dictionarycompose.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dictionaryRepository : DictionaryRepository
) : ViewModel() {
    private val _mainState = MutableStateFlow(MainState())
    val mainState = _mainState.asStateFlow()

    fun onEvent(mainUiEvents: MainUiEvents) {
        when(mainUiEvents) {
            MainUiEvents.OnSearchClick -> {
                loadWordResult()
            }
            is MainUiEvents.OnSearchWordChange -> {
                _mainState.update { mainState ->
                    mainState.copy(
                        searchWord = mainUiEvents.newWord.lowercase()
                    )
                }
            }
        }
    }

    private fun loadWordResult() {
        viewModelScope.launch {
            dictionaryRepository.getWordResult(mainState.value.searchWord).collect {response ->
                when(response) {
                    is Response.Error -> Unit
                    is Response.Loading -> {
                        _mainState.update { mainState ->
                            mainState.copy(
                                isLoading = true
                            )
                        }
                    }
                    is Response.Success -> {
                        response.data?.let { wordItem ->
                            _mainState.update { mainState ->
                                mainState.copy(
                                    wordItem = wordItem
                                )
                            }
                        }

                    }
                }

            }
        }
    }
}