package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.data.api

import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.data.models.commit.CommitResponse
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.data.models.gistList.GistResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {

    @GET("")
    fun getAllPublicGists(
        @Query("since") since: String?): Single<List<GistResponse>>

    @GET("")
    fun getSingleListDetails(@Path("id") gistId: String): Single<GistResponse>

    @GET("")
    fun getGistCommits(@Path("id") gistId: String): Single<List<CommitResponse>>
}