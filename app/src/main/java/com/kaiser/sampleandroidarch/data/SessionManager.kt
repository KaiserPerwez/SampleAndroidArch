package com.kaiser.sampleandroidarch.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.kaiser.sampleandroidarch.data.model.UserModel
import com.kaiser.sampleandroidarch.data.remote.network.ResourceAuth
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton


/* Managing Authentication with Dagger --> CodingWithMitch */
@Singleton
class SessionManager @Inject constructor() {

    private val _cachedUser = MutableLiveData<ResourceAuth<UserModel>>()
    val cachedUser: LiveData<ResourceAuth<UserModel>> get() = _cachedUser

    fun authenticateWithId(liveUser: LiveData<ResourceAuth<UserModel>>) =
        liveData<ResourceAuth<UserModel>>(Dispatchers.IO) {
            emit(ResourceAuth.Loading())
            try {
                _cachedUser.postValue(liveUser.value)
                emit(ResourceAuth.Authenticated(data = _cachedUser.value!!.data!!))
            } catch (exception: Exception) {
                emit(ResourceAuth.Error(message = exception.message ?: "Error Occurred!"))
            } finally {

            }
        }

    fun logOut() = liveData<ResourceAuth<UserModel>>(Dispatchers.IO) {
        emit(ResourceAuth.Loading())
        try {
            emit(ResourceAuth.LoggedOut())
        } catch (exception: Exception) {
            emit(ResourceAuth.Error(message = exception.message ?: "Error while logging out"))
        } finally {

        }
    }
}