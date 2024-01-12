package com.futureforge.yesmom.data.retrofit.response

import com.google.gson.annotations.SerializedName

data class PostNotesResponse(

	@field:SerializedName("msg")
	val msg: String? = null,

	@field:SerializedName("data")
	val data: DataA? = null
)

data class DataA(

	@field:SerializedName("id_daily")
	val idDaily: Int? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("id_user")
	val idUser: Int? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String
)
