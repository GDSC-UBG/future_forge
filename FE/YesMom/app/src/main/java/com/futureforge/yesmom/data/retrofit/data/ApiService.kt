package com.futureforge.yesmom.data.retrofit.data

import com.futureforge.yesmom.data.retrofit.response.LoginWithEmailResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("login")
    suspend fun loginWithEmail(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginWithEmailResponse
}