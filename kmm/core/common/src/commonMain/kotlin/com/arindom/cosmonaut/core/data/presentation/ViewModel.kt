package com.arindom.cosmonaut.core.data.presentation

import kotlinx.coroutines.CoroutineScope

expect abstract class ViewModel() {
    val viewModelScope: CoroutineScope
    protected fun onCleared()
}