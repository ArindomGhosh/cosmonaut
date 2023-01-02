package com.arindom.cosmonaut.core.data.presentation

import kotlinx.coroutines.CoroutineScope
import androidx.lifecycle.viewModelScope as androidXViewModelScope

actual abstract class ViewModel : androidx.lifecycle.ViewModel() {
    actual val viewModelScope: CoroutineScope = androidXViewModelScope
    actual override fun onCleared() {
        super.onCleared()
    }
}