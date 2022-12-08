package com.saneet.demo.network

import com.saneet.demo.models.Country
import io.reactivex.Single
import retrofit2.http.GET

class APIService {
    interface CoroutineService {
        @GET("peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
        suspend fun getCountries(): List<Country>
    }

    interface RxService {
        @GET("peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
        suspend fun getCountries(): Single<List<Country>>
    }
}