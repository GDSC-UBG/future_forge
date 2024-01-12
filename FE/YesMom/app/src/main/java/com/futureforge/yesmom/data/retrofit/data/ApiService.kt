package com.futureforge.yesmom.data.retrofit.data

import com.futureforge.yesmom.data.retrofit.response.CalendarCreateResponse
import com.futureforge.yesmom.data.retrofit.response.LoginWithEmailResponse
import com.futureforge.yesmom.data.retrofit.response.PostNotesResponse
import com.futureforge.yesmom.data.retrofit.response.RegisterWithEmailResponse
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
    @FormUrlEncoded
    @POST("register")
    suspend fun registerWithEmail(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("role") role: String = "client",
        @Field("fcm_token") fcm_token: String = "d_oYNemQRmu-IkJoaY3ifG:APA91bHtsQE4YDeb3HzmyWY7fnut_p8sU31meZl1YZVszFz_35fFuXTmLYomd1d6LGvCTdOSVPd-ibeXsqqSc0IlOLElDvtm0KT78uD6JQon9tqhUKnKkl9wxVUPqILxNq5MgyeDtDQ1",
    ): RegisterWithEmailResponse


    @FormUrlEncoded
    @POST("calender")
    suspend fun postSchedule(
        @Field("title") title: String = "Meeting",
        @Field("text") text: String = "Discuss project updates.",
        @Field("type") type: String = "once",
        @Field("date") date: String = "2024-01-12 10:50:25",
    ): CalendarCreateResponse


    @FormUrlEncoded
    @POST("notes")
    suspend fun postNotesResponse(
        @Field("text") text: String = "example2",
        @Field("emotional_score") emotional_score: Int = 5,
    ): PostNotesResponse


}