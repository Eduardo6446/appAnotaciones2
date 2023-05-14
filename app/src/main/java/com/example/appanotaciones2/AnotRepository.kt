package com.example.appanotaciones2

import androidx.annotation.WorkerThread
import com.example.appanotaciones2.model.Anotacion
import kotlinx.coroutines.flow.Flow

class AnotRepository(private val anotDao: AnotDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allAnots: Flow<List<Anotacion>> = anotDao.getAlphabetizedWords()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(anotacion: Anotacion) {
        anotDao.insert(anotacion)
    }
}