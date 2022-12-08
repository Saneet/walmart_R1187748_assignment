package com.saneet.demo.countrylist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saneet.demo.models.Country
import com.saneet.demo.network.APIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CountryListViewModel @Inject constructor(private val service: APIService.CoroutineService) :
    ViewModel() {
    private val _countryList = MutableLiveData<List<Country>>()
    val countryList = _countryList

    fun fetchCountries() {
        viewModelScope.launch {
            val list = withContext(Dispatchers.IO) {
                service.getCountries()
            }
            //postValue() always posts to the main thread
            _countryList.postValue(list)
        }
    }
}