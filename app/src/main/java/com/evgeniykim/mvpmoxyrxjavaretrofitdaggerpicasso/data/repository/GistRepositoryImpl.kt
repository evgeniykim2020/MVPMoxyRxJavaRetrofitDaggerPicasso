package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.data.repository

import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.data.api.GithubApi
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.data.converters.GistsConverter
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.models.Commit
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.models.Gist
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.models.GistDetails
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.repository.GistRepository
import com.google.gson.internal.bind.util.ISO8601Utils
import io.reactivex.Single
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class GistRepositoryImpl @Inject constructor(private val api: GithubApi): GistRepository {
    override fun getAllPublicGists(): Single<List<Gist>> {
        val date = ISO8601Utils.format(Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(7)))
        return api
            .getAllPublicGists(date)
            .map { GistsConverter.convertFromNetwork(it) }
    }

    override fun getSingleList(id: String): Single<GistDetails> {
        return api
            .getSingleListDetails(id)
            .map { GistsConverter.convertFromNetworkDetails(it) }
    }

    override fun getGistCommits(id: String): Single<List<Commit>> {
        return api
            .getGistCommits(id)
            .map { GistsConverter.convertCommitFromNetwork(it) }
    }
}