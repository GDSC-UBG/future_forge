package com.futureforge.yesmom.ui.pages.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.futureforge.yesmom.common.UiState
import com.futureforge.yesmom.data.repo.YesMomRepository
import com.futureforge.yesmom.data.retrofit.response.LoginWithEmailResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: YesMomRepository
) : ViewModel() {

    private val _loginState: MutableStateFlow<UiState<LoginWithEmailResponse>> = MutableStateFlow(
        UiState.Loading
    )
    val loginState: StateFlow<UiState<LoginWithEmailResponse>> get() = _loginState


    private val _isLogin: MutableStateFlow<UiState<Boolean>> = MutableStateFlow(
        UiState.Loading
    )
    val isLogin: StateFlow<UiState<Boolean>> get() = _isLogin

    fun setLoginState(state: UiState<LoginWithEmailResponse>) {
        _loginState.value = state
    }




    fun getIsAuthLogin() {
        viewModelScope.launch {
            repository.getIsAuthLogin()
                .catch {
                    _isLogin.value = UiState.Error("Failed")
                }
                .collect {
                    _isLogin.value = UiState.Success(it)
                }
        }

    }




    fun loginWithEmail(email: String, password: String) {
        viewModelScope.launch {
            repository.loginWithEmail(email, password)
                .catch {
                    _loginState.value = UiState.Error(it.message.toString())
                }
                .collect {
                    if (!it.key.isNullOrEmpty()) {
                        _loginState.value = UiState.Success(it)
                        repository.saveSessionData(
                            it.key.toString(),
//                            userId = it.userId
                        )
                    } else {
                        _loginState.value = UiState.Error("Failed")
                    }

                }
        }

    }
}