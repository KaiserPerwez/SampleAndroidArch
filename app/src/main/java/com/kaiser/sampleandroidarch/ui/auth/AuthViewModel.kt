package com.kaiser.sampleandroidarch.ui.auth

import androidx.lifecycle.*
import com.kaiser.sampleandroidarch.data.model.UserModel
import com.kaiser.sampleandroidarch.data.remote.network.ResourceAuth
import com.kaiser.sampleandroidarch.data.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class AuthViewModel @Inject constructor(private val authRepo: AuthRepository) : ViewModel() {

    val userMediatorLiveData: MediatorLiveData<UserModel> get() = MediatorLiveData()

    private val _userDetails = MutableLiveData<UserModel>()
    val userDetails: LiveData<UserModel> get() = _userDetails
    private val _isBusy = MutableLiveData(false)
    val isBusy: LiveData<Boolean> get() = _isBusy


    init {
        fetchUserDetails(1)
    }

    fun fetchUserDetails(id: Int) = liveData<ResourceAuth<UserModel>>(Dispatchers.IO) {
        _isBusy.postValue(true)
        emit(ResourceAuth.Loading())
        try {
            _userDetails.postValue(authRepo.getUserDetails(id))
            emit(ResourceAuth.Authenticated(data = userDetails.value!!))
        } catch (exception: Exception) {
            emit(ResourceAuth.Error(message = exception.message ?: "Error Occurred!"))
        } finally {
            _isBusy.postValue(false)
        }
    }
}