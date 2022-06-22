package com.bcci.prfetcher

import android.app.Application
import com.bcci.prfetcher.di.component.ApplicationComponent
import com.bcci.prfetcher.di.component.DaggerApplicationComponent
import com.bcci.prfetcher.di.module.ApplicationModule

class PRFetcherApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }

    private fun getDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}