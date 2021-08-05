package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.data.models.gistList

import com.google.gson.annotations.SerializedName

data class OwnerResponse(
    @SerializedName("login")
    val login: String?,

    @SerializedName("avatar_url")
    val avatarUrl: String?
)
