package com.futureforge.yesmom.di

import android.content.Context
import com.futureforge.yesmom.data.repo.YesMomRepository
import com.futureforge.yesmom.data.retrofit.data.ApiConfig
import com.futureforge.yesmom.preferences.SessionPreference
import com.futureforge.yesmom.preferences.dataStore
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): YesMomRepository {
        val pref = SessionPreference.getInstance(context.dataStore)
        val token = runBlocking { pref.getSessionToken() }
        val apiService = ApiConfig.getApiService(token)

        return YesMomRepository.getInstance(apiService, pref)
    }
}