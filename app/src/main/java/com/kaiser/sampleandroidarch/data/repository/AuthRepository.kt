package com.kaiser.sampleandroidarch.data.repository

import com.kaiser.sampleandroidarch.data.model.UserModel
import com.kaiser.sampleandroidarch.data.remote.api.AuthApi
import com.kaiser.sampleandroidarch.data.remote.network.ApiRequest
import javax.inject.Inject

class AuthRepository @Inject constructor(private val api: AuthApi) : ApiRequest() {
    suspend fun getUserDetails(id: Int): UserModel =
        apiRequest {
            api.fetchUserById(id)
        }
}