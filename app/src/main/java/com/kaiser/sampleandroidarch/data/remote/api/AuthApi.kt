package com.kaiser.sampleandroidarch.data.remote.api

import com.kaiser.sampleandroidarch.data.model.UserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {

    @GET("users/{id}")
    suspend fun fetchUserById(@Path("id") id: Int): Response<UserModel>
}