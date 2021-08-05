package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.data.models.commit

import com.google.gson.annotations.SerializedName

data class CommitResponse(
    @SerializedName("version")
    val version: String?,

    @SerializedName("change_status")
    val commitData: CommitDataResponse?
)
