package com.futureforge.yesmom.data.retrofit.response

import com.google.gson.annotations.SerializedName

data class RegisterWithEmailResponse(

	@field:SerializedName("msg")
	val msg: String? = null,

	@field:SerializedName("data")
	val data: Data
)

data class Data(

	@field:SerializedName("name")
	val name: String
)
