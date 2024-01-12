package com.futureforge.yesmom.data.repo

import com.futureforge.yesmom.data.retrofit.data.ApiService
import com.futureforge.yesmom.data.retrofit.response.CalendarCreateResponse
import com.futureforge.yesmom.data.retrofit.response.LoginWithEmailResponse
import com.futureforge.yesmom.data.retrofit.response.PostNotesResponse
import com.futureforge.yesmom.data.retrofit.response.RegisterWithEmailResponse
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

    suspend fun saveSessionData(
        token: String,
//        userId: Int
    ){
        pref.saveTokenSession(token)
    }

    fun removeSession(){
        coroutineScope.launch(Dispatchers.IO) {
            pref.removeSession()
        }
    }

//    fun getUserIdSession() : Int{
//        return pref.getIdUser()
//    }

    suspend fun loginWithEmail(email: String, password: String): Flow<LoginWithEmailResponse> {
        return flowOf( apiService.loginWithEmail(email, password))
    }
    suspend fun registerWithEmail(name : String, email: String, password: String): Flow<RegisterWithEmailResponse> {
        return flowOf( apiService.registerWithEmail(name = name, email = email, password = password))
    }
    suspend fun calendarCreate(title: String, text: String, type: String, date: String): Flow<CalendarCreateResponse>{
        return flowOf( apiService.postSchedule(title, text, type, date))
    }

    suspend fun postNotesResponse(text: String,emotional_score: Int): Flow<PostNotesResponse>{
        return flowOf( apiService.postNotesResponse( text, emotional_score))
    }

    companion object {
        fun getInstance(
            apiService: ApiService,
            pref: SessionPreference
        ): YesMomRepository = YesMomRepository( apiService, pref)
    }
}