package com.futureforge.yesmom.ui.pages.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.futureforge.yesmom.data.repo.YesMomRepository
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val repository: YesMomRepository,
) : ViewModel()  {
    fun deleteToken() {
        viewModelScope.launch {
            repository.removeSession()
        }
    }

}