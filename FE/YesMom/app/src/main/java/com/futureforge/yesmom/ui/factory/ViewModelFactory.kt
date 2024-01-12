package com.futureforge.yesmom.ui.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.futureforge.yesmom.data.repo.YesMomRepository
import com.futureforge.yesmom.di.Injection
import com.futureforge.yesmom.ui.pages.home.HomeViewModel
import com.futureforge.yesmom.ui.pages.login.LoginViewModel
import com.futureforge.yesmom.ui.pages.profile.ProfileViewModel

class ViewModelFactory(private val repository: YesMomRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }else if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        fun getInstance(context: Context): ViewModelFactory =
            ViewModelFactory(Injection.provideRepository(context))
    }
}