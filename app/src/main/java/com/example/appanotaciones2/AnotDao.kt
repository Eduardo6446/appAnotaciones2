package com.example.appanotaciones2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appanotaciones2.model.Anotacion
import kotlinx.coroutines.flow.Flow

@Dao
interface AnotDao {
    @Query("SELECT * FROM tareas ORDER BY tarea ASC")
    fun getAlphabetizedWords(): Flow<List<Anotacion>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(anotacion: Anotacion)

    @Query("DELETE FROM tareas")
    suspend fun deleteAll()
}