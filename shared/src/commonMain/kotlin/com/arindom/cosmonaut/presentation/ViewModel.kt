package com.arindom.cosmonaut.presentation

import kotlinx.coroutines.CoroutineScope

expect abstract class ViewModel() {
    val viewModelScope: CoroutineScope
    protected fun onCleared()
}