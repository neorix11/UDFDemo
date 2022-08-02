package com.bluelampcreative.udfdemo.core

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T>: ViewModel() {
    abstract val state: IStateReducer<T, Any>
}