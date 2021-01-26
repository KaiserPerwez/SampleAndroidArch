package com.kaiser.sampleandroidarch.data.model

import com.google.gson.annotations.Expose

data class User(@Expose val id: Int, @Expose val name: String, @Expose val username: String)