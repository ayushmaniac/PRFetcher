package com.bcci.prfetcher.ui.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bcci.prfetcher.R
import com.bcci.prfetcher.di.component.ActivityComponent
import com.bcci.prfetcher.ui.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel>() {

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {

    }
}