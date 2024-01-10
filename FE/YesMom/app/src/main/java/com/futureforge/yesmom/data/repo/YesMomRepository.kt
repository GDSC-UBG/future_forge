package com.futureforge.yesmom.data.repo

import com.futureforge.yesmom.data.retrofit.data.ApiService
import com.futureforge.yesmom.data.retrofit.response.LoginWithEmailResponse
import com.futureforge.yesmom.preferences.SessionPreference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class YesMomRepository(private val apiService: ApiService,
                       private  val pref: SessionPreference) {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun getIsAuthLogin(): Flow<Boolean> {
        return pref.getSessionLogin()
    }

    suspend fun saveSessionData(token: String, userId: Int){
        pref.saveTokenSession(token, userId)
    }

    fun removeSession(){
        coroutineScope.launch(Dispatchers.IO) {
            pref.removeSession()
        }
    }

    fun getUserIdSession() : Int{
        return pref.getIdUser()
    }

    suspend fun loginWithEmail(email: String, password: String): Flow<LoginWithEmailResponse> {
        return flowOf( apiService.loginWithEmail(email, password))
    }

    companion object {
        fun getInstance(
            apiService: ApiService,
            pref: SessionPreference
        ): YesMomRepository = YesMomRepository( apiService, pref)
    }
}