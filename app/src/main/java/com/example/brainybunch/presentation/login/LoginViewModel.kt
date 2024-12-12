package com.example.brainybunch.presentation.login

import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import com.example.brainybunch.component.MyState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow<MyState>(MyState.Idle)
    val state:StateFlow<MyState> = _state

    private val UID = stringPreferencesKey("UID")

}