package com.kaiser.sampleandroidarch.di

import com.kaiser.sampleandroidarch.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule { //to contribute the various activity instances

    @ContributesAndroidInjector
    abstract fun contributeAuthActivity(): AuthActivity

    /*
    @ContributesAndroidInjector
    abstract fun contributeSecondActivity():SecondActivity
    */
}