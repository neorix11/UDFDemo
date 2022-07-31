package com.bluelampcreative.udfdemo.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly

interface IStateReducer <STATE, ACTION>: StateFlow<STATE> {
    fun handleAction(action: ACTION)
}

private class StateReducer<STATE, ACTION>(
    initialState: STATE,
    reduceState: (STATE, ACTION) -> STATE,
    scope: CoroutineScope
): IStateReducer<STATE, ACTION> {

    private val events = Channel<ACTION>()

    private val stateFlow = events
        .receiveAsFlow()
        .runningFold(initialState, reduceState)
        .stateIn(scope, Eagerly, initialState)

    override val replayCache: List<STATE>
        get() = stateFlow.replayCache

    override suspend fun collect(collector: FlowCollector<STATE>): Nothing {
        stateFlow.collect(collector)
    }

    override val value: STATE
        get() = stateFlow.value

    override fun handleAction(action: ACTION) {
        events.trySend(action)
    }
}

fun <STATE, ACTION> ViewModel.reducer(
    initialState: STATE,
    reduceState: (STATE, ACTION) -> STATE
): IStateReducer<STATE, ACTION> = StateReducer(initialState, reduceState, viewModelScope)