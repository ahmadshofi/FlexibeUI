package com.ahmad.sportview.Overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmad.sportview.Network.SportApi
import com.ahmad.sportview.Network.SportApiFilter
import com.ahmad.sportview.Network.SportProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

enum class SportApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel: ViewModel(){
    private val _respones = MutableLiveData<String>()

    val response:LiveData<String>
    get() = _respones

    private val _status = MutableLiveData<SportApiStatus>()
    val status: LiveData<SportApiStatus>
    get() = _status

    private val _properties = MutableLiveData<List<SportProperty>>()

    val properties: LiveData<List<SportProperty>>
    get() = _properties

    private val _navigateToSelectedProperty = MutableLiveData<SportProperty>()

    val navigateToSelectedProperty: LiveData<SportProperty>
        get() = _navigateToSelectedProperty

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getSportProperties(SportApiFilter.SHOW_ALL)
    }


    private fun getSportProperties(filter: SportApiFilter){
        coroutineScope.launch {
            var getPropertiesDeferred = SportApi.retrofitService.getProperties(filter.value)
            try {
                _status.value = SportApiStatus.LOADING
                val listResult = getPropertiesDeferred.await()
                _status.value =SportApiStatus.DONE
                _properties.value = listResult
            }catch (e: Exception){
                _status.value = SportApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun updateFilter(filter: SportApiFilter) {
        getSportProperties(filter)
    }
}