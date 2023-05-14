package com.example.appanotaciones2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.appanotaciones2.model.Anotacion
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Anotacion::class), version = 1, exportSchema = false)
public abstract class AnotRoomDatabase : RoomDatabase() {

    abstract fun anotDao(): AnotDao

    private class AnotDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var anotDao = database.anotDao()

                    // Delete all content here.
                    anotDao.deleteAll()

                    // Add sample words.
                    var anot = Anotacion(1, "tarea1", Finalizado = true)
                    anotDao.insert(anot)
                    anot = Anotacion(2,"tarea1",Finalizado = true)
                    anotDao.insert(anot)

                    // TODO: Add your own words!
                    anot = Anotacion(3,"tarea1",Finalizado = true)
                    anotDao.insert(anot)
                }
            }
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AnotRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): AnotRoomDatabase  {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AnotRoomDatabase::class.java,
                    "tareas_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}