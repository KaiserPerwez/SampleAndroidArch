package com.kaiser.sampleandroidarch.di.auth

import com.kaiser.sampleandroidarch.data.remote.api.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthModule {

    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)
}