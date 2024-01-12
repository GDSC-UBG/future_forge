package com.futureforge.yesmom.ui.pages.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.futureforge.yesmom.common.UiState
import com.futureforge.yesmom.data.repo.YesMomRepository
import com.futureforge.yesmom.data.retrofit.response.RegisterWithEmailResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val repository: YesMomRepository,
) : ViewModel()  {

    private val _registerState: MutableStateFlow<UiState<RegisterWithEmailResponse>> =
        MutableStateFlow(
            UiState.Loading
        )
    val registerState: StateFlow<UiState<RegisterWithEmailResponse>> get() = _registerState


    fun setRegisterState(state: UiState<RegisterWithEmailResponse>) {
        _registerState.value = state
    }


    fun registerWithEmail(
        username: String, email: String,
        password: String
    ) {
        viewModelScope.launch {
            repository.registerWithEmail(username, email, password)
                .catch {
                    _registerState.value = UiState.Error("cannot post data")
                }
                .collect { registerResponse ->
                    if(!registerResponse.data.name.isNullOrEmpty()){
                        _registerState.value = UiState.Success(registerResponse)
                    }else{
                        _registerState.value = UiState.Error("cannot post data")
                    }

                }
        }
    }
}