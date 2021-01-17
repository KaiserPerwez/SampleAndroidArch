package com.kaiser.sampleandroidarch.di

import androidx.lifecycle.ViewModelProvider
import com.kaiser.sampleandroidarch.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}