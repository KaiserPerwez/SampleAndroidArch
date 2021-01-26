package com.kaiser.sampleandroidarch.ui.auth

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.kaiser.sampleandroidarch.R
import com.kaiser.sampleandroidarch.data.remote.network.ResourceAuth
import com.kaiser.sampleandroidarch.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class AuthActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private val searchText by lazy { findViewById<EditText>(R.id.user_id_input) }
    private val authButton by lazy { findViewById<Button>(R.id.login_button) }
    lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initUiObserversAndListeners()

    }

    private fun initUiObserversAndListeners() {
        //init
        authViewModel =
            ViewModelProvider(this, viewModelProviderFactory).get(AuthViewModel::class.java)

        //Listeners
        authButton?.setOnClickListener {
            authViewModel.fetchUserDetails(1).observe(this, {
                it?.let { resource ->
                    when (resource.statusAuth) {
                        ResourceAuth.StatusAuth.AUTHENTICATED -> {
                            Log.d(TAG, "Searched User is ${it.data?.name ?: "No Name Available"}")
                        }
                        ResourceAuth.StatusAuth.ERROR -> {
                            // binding.root.showSnackbar(it.message.toString())
                            Log.d(TAG, "ERROR....${it.message}")
                        }
                        ResourceAuth.StatusAuth.LOADING -> {
                            Log.d(TAG, "LOADING............")
                        }
                        else -> {

                        }
                    }
                }

            })

        }
    }

    companion object {
        private const val TAG = "AuthActivity"
    }
}