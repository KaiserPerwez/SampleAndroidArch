package com.kaiser.sampleandroidarch.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kaiser.sampleandroidarch.data.model.User
import com.kaiser.sampleandroidarch.network.auth.AuthApi
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(val authApi: AuthApi) : ViewModel() {


    init {
        withoutReactiveStream()
    }

    /*
     val userMediatorLiveData:MediatorLiveData<User> = MediatorLiveData()

     fun authByReactiveStream(){
          val userLiveData:LiveData<User> =LiveDataReactiveStreams.fromPublisher { authApi.fetchUserById(1).subscribeOn(Schedulers.io()) }
          userMediatorLiveData.addSource(userLiveData){//onChanged
              userMediatorLiveData.value=it
              userMediatorLiveData.removeSource(userLiveData)
          }
      }*/
    fun withoutReactiveStream() {
        authApi.fetchUserById(1).toObservable().subscribeOn(Schedulers.io()).subscribe(object :
            Observer<User> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(user: User) {

                Log.d("XXXXXXXXXXXXXXX", "authApi is ${user.name}")
            }

            override fun onError(e: Throwable) {
                Log.d("XXXXXXXXXXXXXXX", "authApi ERROR ${e.localizedMessage}")

            }

            override fun onComplete() {
            }
        })
    }
}