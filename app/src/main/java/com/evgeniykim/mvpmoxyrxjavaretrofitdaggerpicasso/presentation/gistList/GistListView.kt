package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.presentation.gistList

import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.models.Gist
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.presentation.utils.AddToEndSingleByTagStateStrategy
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.AddToEndSingleTagStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface GistListView: MvpView {

    fun showGists(gists : List<Gist>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(message: String?)

    @StateStrategyType(value = AddToEndSingleByTagStateStrategy::class, tag = "TAG_LOADING")
    fun startLoading()

    @StateStrategyType(value = AddToEndSingleByTagStateStrategy::class, tag = "TAG_LOADING")
    fun finishLoading()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showUserDetails(id: String)
}