package com.kaiser.sampleandroidarch.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.kaiser.sampleandroidarch.data.model.UserModel
import com.kaiser.sampleandroidarch.data.remote.network.ResourceAuth
import com.kaiser.sampleandroidarch.data.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class AuthViewModel @Inject constructor(private val authRepo: AuthRepository) : ViewModel() {


    fun fetchUserDetails(id: Int) = liveData<ResourceAuth<UserModel>>(Dispatchers.IO) {
        emit(ResourceAuth.Loading())
        try {
            val data = authRepo.getUserDetails(id)
            emit(ResourceAuth.Authenticated(data)) //notify activity
        } catch (exception: Exception) {
            emit(ResourceAuth.Error(message = exception.message ?: "Error Occurred!"))
        } finally {
        }
    }
}