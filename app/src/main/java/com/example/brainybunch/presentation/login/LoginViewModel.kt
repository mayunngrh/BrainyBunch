package com.example.brainybunch.presentation.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor():ViewModel() {
    private val _username = MutableStateFlow<String>("")
    val username: StateFlow<String> = _username

}