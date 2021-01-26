package com.kaiser.sampleandroidarch.data.remote.network

import android.app.Application
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.kaiser.sampleandroidarch.BuildConfig
import com.kaiser.sampleandroidarch.data.remote.api.ConstantsUrl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetworkingModule {


    @Provides
    @Singleton
    fun providesLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun providesChuckerInterceptor(application: Application) =
        ChuckerInterceptor.Builder(application)
            .collector(ChuckerCollector(application))
            .maxContentLength(250000L)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(false)
            .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        chuckerInterceptor: ChuckerInterceptor,
        apiInterceptor: ApiInterceptor
    ) = OkHttpClient().newBuilder().also { okHttpClient ->
        okHttpClient.callTimeout(40, TimeUnit.SECONDS)
        okHttpClient.connectTimeout(40, TimeUnit.SECONDS)
        okHttpClient.readTimeout(40, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(40, TimeUnit.SECONDS)
        okHttpClient.addInterceptor(apiInterceptor)
        if (BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(loggingInterceptor)
            okHttpClient.addInterceptor(chuckerInterceptor)
        }
    }.build()

    @Provides
    @Singleton
    fun providesConverterFactory(): Converter.Factory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun providesRetrofitInstance(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit {

        return Retrofit.Builder().baseUrl(ConstantsUrl.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

}