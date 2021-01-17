package com.kaiser.sampleandroidarch.di.auth

import androidx.lifecycle.ViewModel
import com.kaiser.sampleandroidarch.di.ViewModelKey
import com.kaiser.sampleandroidarch.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthViewModel): ViewModel
}