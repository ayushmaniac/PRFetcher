package com.bcci.prfetcher.ui.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bcci.prfetcher.R
import com.bcci.prfetcher.di.component.ActivityComponent
import com.bcci.prfetcher.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>() {

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {
        initThings()
        observeData()
    }

    private fun initThings() {
        viewModel.getAllPullRequest()
        rvPullRequests.layoutManager = LinearLayoutManager(this)
    }

    private fun observeData() {
        viewModel.pullRequestLiveData.observe(this){listOfPRs->
            if(listOfPRs.isNotEmpty()){
                rvPullRequests.adapter = PRAdapter(listOfPRs)
            }
        }
    }
}