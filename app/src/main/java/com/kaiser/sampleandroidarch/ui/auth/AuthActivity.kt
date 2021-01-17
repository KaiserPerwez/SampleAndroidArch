package com.kaiser.sampleandroidarch.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.kaiser.sampleandroidarch.R
import com.kaiser.sampleandroidarch.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class AuthActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory


    lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        authViewModel =
            ViewModelProvider(this, viewModelProviderFactory).get(AuthViewModel::class.java)
        Log.d(TAG, "onCreate: ${authViewModel.v}")
    }

    companion object {
        private const val TAG = "AuthActivity"
    }
}