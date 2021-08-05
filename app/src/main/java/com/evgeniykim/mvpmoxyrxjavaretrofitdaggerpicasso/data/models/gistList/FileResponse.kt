package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.data.models.gistList

import com.google.gson.annotations.SerializedName

data class FileResponse(
    @SerializedName("filename")
    val name: String?,

    @SerializedName("content")
    val content: String?
)
