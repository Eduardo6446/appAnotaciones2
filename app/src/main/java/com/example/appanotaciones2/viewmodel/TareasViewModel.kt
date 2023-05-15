package com.example.appanotaciones2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appanotaciones2.model.TareasModel
import com.example.appanotaciones2.model.TareasProvider

class TareasViewModel: ViewModel() {
    val tareasModel = MutableLiveData<TareasModel>()

    fun getTareas(){
        val tarea:TareasModel = TareasProvider.getTareas()
        tareasModel.postValue(tarea)
    }
}