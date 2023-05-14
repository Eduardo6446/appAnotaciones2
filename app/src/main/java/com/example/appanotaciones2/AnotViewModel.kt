package com.example.appanotaciones2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.appanotaciones2.model.Anotacion
import kotlinx.coroutines.launch

class AnotViewModel(private val repository: AnotRepository) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allAnots: LiveData<List<Anotacion>> = repository.allAnots.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(anotacion: Anotacion) = viewModelScope.launch {
        repository.insert(anotacion)
    }


}

class AnotViewModelFactory(private val repository: AnotRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnotViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AnotViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}