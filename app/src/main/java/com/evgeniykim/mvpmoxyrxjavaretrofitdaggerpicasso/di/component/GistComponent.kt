package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.di.component

import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.di.module.GistModule
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.di.scope.GistScope
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.presentation.gistDetails.GistDetailsPresenter
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.presentation.gistList.GistListPresenter
import dagger.Subcomponent

@GistScope
@Subcomponent(modules = [GistModule::class])
interface GistComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): GistComponent
    }

    fun inject(gistDetailsPresenter: GistDetailsPresenter)
    fun inject(gistListPresenter: GistListPresenter)
}