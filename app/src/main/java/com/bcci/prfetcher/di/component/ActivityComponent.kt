package com.bcci.prfetcher.di.component

import com.bcci.prfetcher.di.module.ActivityModule
import com.bcci.prfetcher.di.scope.ActivityScope
import com.bcci.prfetcher.ui.screens.MainActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}