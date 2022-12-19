package com.arindom.cosmonaut.androidApp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arindom.cosmonaut.domain.entities.RocketLaunchEntity
import com.arindom.cosmonaut.domain.entities.UiError
import com.arindom.cosmonaut.domain.usecasses.GetLaunchesUseCase
import com.arindom.cosmonaut.domain.util.DomainWrapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class MainUiState(
    val loading: Boolean = false,
    val launches: List<RocketLaunchEntity> = emptyList(),
    val uiError: UiError? = null
)

class MainViewModel(
    private val getLaunchesUseCase: GetLaunchesUseCase
) : ViewModel() {
    private val _mainUiState = MutableStateFlow<MainUiState>(MainUiState())
    val mainUiState = _mainUiState.asStateFlow()
    fun getAllLaunches() {
        viewModelScope.launch {
            _mainUiState.update {
                _mainUiState.value.copy(
                    loading = true,
                )
            }
            with(getLaunchesUseCase()) {
                when (this) {
                    is DomainWrapper.Entity -> {
                        _mainUiState.update {
                            _mainUiState.value.copy(
                                loading = false,
                                launches = this.data,
                                uiError = null
                            )
                        }
                    }
                    is DomainWrapper.Error -> _mainUiState.update {
                        _mainUiState.value.copy(
                            loading = false,
                            uiError = this.uiError
                        )
                    }
                }
            }
        }
    }
}