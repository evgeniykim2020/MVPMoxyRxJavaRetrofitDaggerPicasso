package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.repository

import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.models.Commit
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.models.Gist
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.models.GistDetails
import io.reactivex.Single

interface GistRepository {

    fun getAllPublicGists(): Single<List<Gist>>

    fun getSingleList(id: String): Single<GistDetails>

    fun getGistCommits(id: String): Single<List<Commit>>
}