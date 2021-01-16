package com.kaiser.sampleandroidarch.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule { //to contribute the instances which usually do not change throughout the app lifecycle e.g Retrofit,Glide instance etc

    @Provides
    @Singleton
    fun provideTestString(): String = "Sample String"
}