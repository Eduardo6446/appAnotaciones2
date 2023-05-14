package com.example.appanotaciones2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="tareas")
class Anotacion(
                @PrimaryKey(autoGenerate = true) val id: Long,
                @ColumnInfo(name="tarea") val tarea:String,
                @ColumnInfo(name="Finalizado") val Finalizado:Boolean) {

}

/*var id:Long=0,
var tarea:String ="",
var Finalizado: Boolean=false*/