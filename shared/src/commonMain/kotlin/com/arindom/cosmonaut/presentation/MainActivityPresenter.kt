package com.arindom.cosmonaut.presentation

import com.arindom.cosmonaut.domain.entities.RocketLaunchEntity
import com.arindom.cosmonaut.domain.entities.UiError
import com.arindom.cosmonaut.domain.usecasses.GetLaunchesUseCase
import com.arindom.cosmonaut.domain.util.DomainWrapper

data class MainUiState(
    val loading: Boolean = false,
    val launches: List<RocketLaunchEntity> = emptyList(),
)

sealed interface Intent {
    object GetAllLaunches : Intent
}

sealed interface SideEffect {
    data class ErrorAlert(val uiError: UiError) : SideEffect
}

class MainActivityPresenter(
    private val getLaunchesUseCase: GetLaunchesUseCase
) : Presenter<MainUiState, Intent, SideEffect>(MainUiState()) {

    private fun getAllLaunches() = executeTask {
        reduce { copy(loading = true) }
        with(getLaunchesUseCase()) {
            when (this) {
                is DomainWrapper.Entity -> {
                    reduce {
                        copy(
                            loading = false,
                            launches = this@with.data,
                        )
                    }
                }
                is DomainWrapper.Error -> {
                    reduce {
                        copy(loading = false)
                    }
                    postSideEffect(SideEffect.ErrorAlert(this@with.uiError))
                }
            }
        }
    }

    override fun onIntent(intent: Intent) {
        when (intent) {
            Intent.GetAllLaunches -> getAllLaunches()
        }
    }
}