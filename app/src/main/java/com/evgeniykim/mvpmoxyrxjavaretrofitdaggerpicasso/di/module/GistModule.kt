package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.di.module

import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.di.scope.GistScope
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.repository.GistRepository
import dagger.Binds
import dagger.Module

@Module
abstract class GistModule {

    @Binds
    @GistScope
    abstract fun provideGistRepository(gistRepository: GistRepository): GistRepository
}