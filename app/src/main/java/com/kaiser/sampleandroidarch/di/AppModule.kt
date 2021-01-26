package com.kaiser.sampleandroidarch.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.kaiser.sampleandroidarch.R
import com.kaiser.sampleandroidarch.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class AppModule { //to contribute the instances which usually do not change throughout the app lifecycle ie app-level modules ie e.g Retrofit,Glide instance etc


    @Provides
    @Singleton
    fun providesRetrofitInstance(): Retrofit =
        Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideGlideRequestOptions(): RequestOptions =
        RequestOptions
            .placeholderOf(R.drawable.white_background)
            .error(R.drawable.white_background)

    @Provides
    @Singleton
    fun provideGlideInstance(
        application: Application, requestOptions: RequestOptions
    ): RequestManager =
        Glide
            .with(application)
            .setDefaultRequestOptions(requestOptions)


    @Provides
    @Singleton
    fun provideAppLogoDrawable(application: Application): Drawable? =
        ContextCompat.getDrawable(application, R.drawable.logo)


    companion object {
        @Provides
        fun someString(): String {
            return "this is a test string"
        }
    }
}


/*

@Module
class AppModule { //to contribute the instances which usually do not change throughout the app lifecycle ie app-level modules ie e.g Retrofit,Glide instance etc

    @Provides
    @Singleton
    fun provideTestString(): String = "Sample String"
}




@Module
object AppModule { //to contribute the instances which usually do not change throughout the app lifecycle ie app-level modules ie e.g Retrofit,Glide instance etc

    @Provides
    @JvmStatic
    fun provideTestString(): String = "Sample String"
}


 */