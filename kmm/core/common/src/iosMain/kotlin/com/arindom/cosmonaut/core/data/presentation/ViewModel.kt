package com.arindom.cosmonaut.core.data.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

actual abstract class ViewModel {
    actual val viewModelScope: CoroutineScope
        get() = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun clear() {
        viewModelScope.cancel()
        onCleared()
    }

    protected actual fun onCleared() {

    }
}