package com.example.appanotaciones2

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class AnotApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { AnotRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { AnotRepository(database.anotDao()) }
}