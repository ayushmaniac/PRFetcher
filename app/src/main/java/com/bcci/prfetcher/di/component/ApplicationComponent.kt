package com.bcci.prfetcher.di.component

import android.content.Context
import com.bcci.prfetcher.PRFetcherApplication
import com.bcci.prfetcher.data.ApplicationRepository
import com.bcci.prfetcher.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: PRFetcherApplication)

    fun getContext() : Context

    fun getAppRepository() : ApplicationRepository


}