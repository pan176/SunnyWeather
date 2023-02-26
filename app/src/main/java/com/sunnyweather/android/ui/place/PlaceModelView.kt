package com.sunnyweather.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.logic.network.Place

class PlaceModelView : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun savePlace(place: Place) = Repository.savePlace(place)
    fun getSavePlace() = Repository.getSavePlace()
    fun isPlaceSaved() = Repository.isPlaceSaved()
}