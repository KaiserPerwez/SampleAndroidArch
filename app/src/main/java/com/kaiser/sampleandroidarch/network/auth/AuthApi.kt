package com.kaiser.sampleandroidarch.network.auth

import com.kaiser.sampleandroidarch.data.model.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {

    @GET("users/{id}")
    fun fetchUserById(@Path("id") id: Int): Flowable<User>
}