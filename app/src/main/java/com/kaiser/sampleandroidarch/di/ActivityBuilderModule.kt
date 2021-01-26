package com.kaiser.sampleandroidarch.di

import com.kaiser.sampleandroidarch.di.auth.AuthModule
import com.kaiser.sampleandroidarch.di.auth.AuthViewModelModule
import com.kaiser.sampleandroidarch.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [AuthViewModelModule::class, AuthModule::class])
    abstract fun contributeAuthActivity(): AuthActivity


}