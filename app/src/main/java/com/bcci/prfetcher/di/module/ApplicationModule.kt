package com.bcci.prfetcher.di.module

import android.content.Context
import com.bcci.prfetcher.BuildConfig
import com.bcci.prfetcher.PRFetcherApplication
import com.bcci.prfetcher.data.ApplicationRepository
import com.bcci.prfetcher.data.remote.GitHubNetworking
import com.bcci.prfetcher.data.remote.GithubService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: PRFetcherApplication) {

    @Provides
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideNetworkService(): GithubService = GitHubNetworking.create(
        BuildConfig.BASE_URL,
        application.cacheDir,
        10 * 1024 * 1024 // 10MB
    )

    @Provides
    fun provideAppRepository(githubService: GithubService) : ApplicationRepository = ApplicationRepository(githubService)
}