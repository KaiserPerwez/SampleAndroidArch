package com.kaiser.sampleandroidarch.data.remote.network

import java.io.IOException

class ApiException(errorMessage: String) : IOException(errorMessage)
class NoInternetException(errorMessage: String) : IOException(errorMessage)