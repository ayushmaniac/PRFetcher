package com.bcci.prfetcher.ui.screens

import androidx.lifecycle.viewModelScope
import com.bcci.prfetcher.data.ApplicationRepository
import com.bcci.prfetcher.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val applicationRepository: ApplicationRepository
) : BaseViewModel() {

//        http://api.github.com/repos/ayushmaniac/CameraX-Face-Detection/pulls?state=closed
    fun getAllPullRequest() {
        viewModelScope.launch(Dispatchers.IO){
            applicationRepository.getAllPullRequests()
        }

    }

}