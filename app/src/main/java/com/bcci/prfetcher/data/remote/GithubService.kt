package com.bcci.prfetcher.data.remote

import com.bcci.prfetcher.data.model.PRModel
import retrofit2.http.GET

interface GithubService {

    @GET("repos/ayushmaniac/CameraX-Face-Detection/pulls?state=closed")
   suspend fun getAllClosedRequests(): List<PRModel>
}