package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.data.converters

import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.data.models.commit.CommitResponse
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.data.models.gistList.GistResponse
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.models.*


object GistsConverter {

    fun convertFromNetwork(gists: List<GistResponse>): List<Gist> {
        return gists.map {
            convertFromNetwork(it)
        }
    }

    fun convertFromNetwork(gist: GistResponse): Gist {
        with(gist) {
            val ownerFromNetwork = checkNotNull(gist.owner)
            val owner = Owner(
                checkNotNull(ownerFromNetwork.login),
                checkNotNull(ownerFromNetwork.avatarUrl)
            )

            return Gist(
                checkNotNull(id),
                description.let { files?.keys?.first().toString() }, owner
            )
        }
    }

    fun convertFromNetworkDetails(gist: GistResponse): GistDetails {
        with(gist) {
            val ownerFromNetwork = checkNotNull(gist.owner)
            val owner = Owner(
                checkNotNull(ownerFromNetwork.login),
                checkNotNull(ownerFromNetwork.avatarUrl)
            )

            val fileList: MutableList<GistFileInfo> = mutableListOf()

            files?.map { fileList.add(GistFileInfo(it.key, it.value.content.toString())) }

            return GistDetails(
                checkNotNull(id),
                description.let { files?.keys?.first().toString()},
                owner, fileList.toList()
            )
        }

    }

    fun convertCommitFromNetwork(commits: List<CommitResponse>): List<Commit> {
        return commits.map {
            with(it) {
                Commit(
                    checkNotNull(version),
                    checkNotNull(commitData?.deletions),
                    checkNotNull(commitData?.additions)
                )
            }
        }
    }
}