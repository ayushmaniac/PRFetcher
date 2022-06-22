package com.bcci.prfetcher.ui.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bcci.prfetcher.data.ApplicationRepository
import com.bcci.prfetcher.data.model.PRModel
import com.bcci.prfetcher.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val applicationRepository: ApplicationRepository
) : BaseViewModel() {

    private val _pullRequestsLiveData = MutableLiveData<List<PRModel>>()
    val pullRequestLiveData = _pullRequestsLiveData


    fun getAllPullRequest() {
        viewModelScope.launch(Dispatchers.IO){
            val data = applicationRepository.getAllPullRequests()
            _pullRequestsLiveData.postValue(data)
        }

    }

}