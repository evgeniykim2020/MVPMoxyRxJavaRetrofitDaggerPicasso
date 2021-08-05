package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.di.component

import android.content.Context
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context): Builder

        fun build(): ApplicationComponent
    }

    fun githubComponent(): GistComponent.Builder
}