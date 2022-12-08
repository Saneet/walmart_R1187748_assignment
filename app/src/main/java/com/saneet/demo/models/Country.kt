package com.saneet.demo.models

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("capital")
    val capital: String,
)