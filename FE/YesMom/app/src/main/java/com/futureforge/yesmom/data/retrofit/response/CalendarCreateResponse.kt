package com.futureforge.yesmom.data.retrofit.response

import com.google.gson.annotations.SerializedName

data class CalendarCreateResponse(

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)
