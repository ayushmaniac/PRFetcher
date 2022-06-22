package com.bcci.prfetcher.data

import com.bcci.prfetcher.data.remote.GithubService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApplicationRepository @Inject constructor(
    private val githubNetworkService : GithubService
){


   suspend fun getAllPullRequests() = githubNetworkService.getAllClosedRequests()
}