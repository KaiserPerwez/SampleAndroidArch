package com.kaiser.sampleandroidarch.di.auth

import com.kaiser.sampleandroidarch.network.auth.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthModule {

    @Provides
    fun provideAuthApi(retrofit: Retrofit) = retrofit.create(AuthApi::class.java)
}