package com.bcci.prfetcher.ui.base


import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.bcci.prfetcher.PRFetcherApplication
import com.bcci.prfetcher.di.component.ActivityComponent
import com.bcci.prfetcher.di.component.DaggerActivityComponent
import com.bcci.prfetcher.di.module.ActivityModule
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM


    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        setupView(savedInstanceState)
    }

    private fun buildActivityComponent() = DaggerActivityComponent
        .builder()
        .applicationComponent((application as PRFetcherApplication).applicationComponent)
        .activityModule(ActivityModule(this))
        .build()


    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)

    protected abstract fun setupView(savedInstanceState: Bundle?)
}