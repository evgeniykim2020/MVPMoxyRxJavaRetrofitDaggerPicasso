package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.data.models.gistdetails

import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.data.models.gistList.FileResponse
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.data.models.gistList.OwnerResponse
import com.google.gson.annotations.SerializedName

data class GistDetailsResponse(
    @SerializedName("files")
    val files: Map<String, FileResponse>?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("owner")
    val owner: OwnerResponse?
)
