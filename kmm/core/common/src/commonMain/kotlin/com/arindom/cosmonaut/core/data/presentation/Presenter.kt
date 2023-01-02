package com.arindom.cosmonaut.core.data.presentation

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class Presenter<State : Any, Intent : Any, SideEffect : Any>(
    private val initialState: State,
) : ViewModel() {
    private val _intents: MutableSharedFlow<Intent> = MutableSharedFlow()

    private val _states = MutableStateFlow(initialState)


    private val _sideEffects = MutableSharedFlow<SideEffect>(replay = 0)

    val states: StateFlow<State> = _states.asStateFlow()

    val sideEffects: SharedFlow<SideEffect> = _sideEffects.asSharedFlow()

    init {
        viewModelScope.launch {
            _intents.collect(::onIntent)
        }
    }

    protected abstract fun onIntent(intent: Intent)

    fun reduce(reducer: State.() -> State) {
        _states.update(reducer)
    }

    fun postIntent(intent: Intent) {
        viewModelScope.launch {
            _intents.emit(intent)
        }
    }

    protected fun postSideEffect(sideEffect: SideEffect) {
        viewModelScope.launch {
            _sideEffects.emit(sideEffect)
        }
    }

    fun executeTask(action: suspend () -> Unit) {
        viewModelScope.launch {
            action()
        }
    }

}