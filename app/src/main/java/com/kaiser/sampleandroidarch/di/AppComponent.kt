package com.kaiser.sampleandroidarch.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule


@Component(
    modules = [
        AndroidSupportInjectionModule::class, ActivityBuilderModule::class]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindApplication(application: Application): Builder
        fun build(): AppComponent
    }
}