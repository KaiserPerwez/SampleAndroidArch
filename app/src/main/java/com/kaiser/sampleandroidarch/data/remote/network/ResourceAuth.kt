package com.kaiser.sampleandroidarch.data.remote.network


sealed class ResourceAuth<T>(
    val statusAuth: StatusAuth?,
    val data: T? = null,
    val message: String? = ""
) {
    class Authenticated<T>(data: T) : ResourceAuth<T>(StatusAuth.AUTHENTICATED, data)
    class Loading<T> : ResourceAuth<T>(StatusAuth.LOADING)
    class Error<T>(message: String) : ResourceAuth<T>(StatusAuth.ERROR, null, message)
    class AuthenticationFailed<T>(message: String) :
        ResourceAuth<T>(StatusAuth.AUTHENTICATION_FAILED, null, message)

    class TokenExpired<T> : ResourceAuth<T>(StatusAuth.TOKEN_EXPIRED)
    class LoggedOut<T> : ResourceAuth<T>(StatusAuth.LOGGED_OUT)


    enum class StatusAuth {
        AUTHENTICATED, LOADING, ERROR, AUTHENTICATION_FAILED, TOKEN_EXPIRED, LOGGED_OUT
    }
}