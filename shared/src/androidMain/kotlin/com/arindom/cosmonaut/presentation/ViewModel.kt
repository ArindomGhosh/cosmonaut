package com.arindom.cosmonaut.presentation

import kotlinx.coroutines.CoroutineScope
import androidx.lifecycle.ViewModel as AndroidxViewModel
import androidx.lifecycle.viewModelScope as androidXViewModelScope

actual abstract class ViewModel : AndroidxViewModel() {
    actual val viewModelScope: CoroutineScope = androidXViewModelScope
    actual override fun onCleared() {
        super.onCleared()
    }
}