package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.data.models.gistList

import com.google.gson.annotations.SerializedName

data class GistResponse(
    @SerializedName("id")
    val id: String?,

    @SerializedName("files")
    val files: Map<String, FileResponse>?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("owner")
    val owner: OwnerResponse?


)
