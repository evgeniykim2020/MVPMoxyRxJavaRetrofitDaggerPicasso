package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.di

import android.content.Context
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.di.component.ApplicationComponent
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.di.component.GistComponent
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.di.component.DaggerApplicationComponent

object DI {

    lateinit var app: ApplicationComponent
    private var gist: GistComponent? = null

    fun init(context: Context) {
        this.app = DaggerApplicationComponent
            .builder()
            .application(context)
            .build()
    }

    fun getGistComponent(): GistComponent {
        if (gist == null) {
            gist = app.githubComponent().build()
        }
        return gist as GistComponent
    }
}