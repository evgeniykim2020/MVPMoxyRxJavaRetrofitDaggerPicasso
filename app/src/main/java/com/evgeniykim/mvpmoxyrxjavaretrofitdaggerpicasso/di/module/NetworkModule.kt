package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.di.module

import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.data.api.GithubApi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL = ""

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

    @Provides
    @Singleton
    fun providesWatcherApi(retrofit: Retrofit): GithubApi = retrofit.create(GithubApi::class.java)
}