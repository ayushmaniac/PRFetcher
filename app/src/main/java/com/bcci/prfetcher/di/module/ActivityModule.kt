package com.bcci.prfetcher.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.bcci.prfetcher.data.ApplicationRepository
import com.bcci.prfetcher.ui.base.BaseActivity
import com.bcci.prfetcher.ui.screens.MainViewModel
import com.bcci.prfetcher.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class ActivityModule (private val activity: BaseActivity<*>) {

    @Provides
    fun provideContext(
    ) : Context = activity


    @Provides
    fun provideMainViewModel(
        applicationRepository: ApplicationRepository
    ): MainViewModel = ViewModelProvider(
        activity, ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(applicationRepository)
        })[MainViewModel::class.java]
}