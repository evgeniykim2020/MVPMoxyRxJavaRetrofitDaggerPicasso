package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.presentation.gistList

import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.di.DI
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.models.Gist
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.repository.GistRepository
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class GistListPresenter: BasePresenter<GistListView>() {

    @Inject
    lateinit var repository: GistRepository

    init {
        DI.getGistComponent().inject(this)
        loadUsers()
    }

    fun loadUsers() {
        viewState.startLoading()
        disposable.add(repository.getAllPublicGists()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { list ->
                    viewState.showGists(list)
                    viewState.finishLoading()
                },
                {
                    error ->
                    viewState.showError(error.toString())
                    viewState.finishLoading()
                }
            )
        )
    }

    fun userClicked(gist: Gist) {
        viewState.showUserDetails(gist.id)
    }
}